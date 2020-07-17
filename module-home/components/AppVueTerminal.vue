<template>
    <div class="vue-terminal"  @click="handleFocus">
        <div >
            <div class="terminal-window" ref="terminalWindow">
                <p v-if="greeting">{{greeting}}</p>
                <p v-if="defaultTaskCommandd">
                    <span class="prompt"></span><span class="cmd">{{defaultTaskCommandd}}</span>
                </p>

                <p v-for="(item, index) in messageList" :key="index">
                    <span>{{item.time}}</span>
                    <span v-if="item.label" :class="item.type">{{item.label}}</span>

                <pre class="cmd" v-if="!item.message.list">{{item.message}}</pre>

                <span class="cmd" v-else>
                    <pre>{{item.message.text}}</pre>
                    <ul>
                      <li v-for="(li,index) in item.message.list" :key="index" style="list-style-type: none;">
                          <template v-if="li.html">
                              <pre v-html="li.message"></pre>
                          </template>
                          <template v-else>
                            <span v-if="li.label" :class="li.type">{{li.label}}:</span>
                            <pre>{{li.message}}</pre>
                          </template>
                      </li>
                    </ul>
                </span>

                <p v-if="actionResult"> <span class="cmd">{{actionResult}}</span></p>

                <p class="terminal-last-line" ref="terminalLastLine">
                  <span v-if="lastLineContent==='&nbsp'">
                    <span v-if="typeof prompt !== 'undefined'" class="prompt">{{prompt}}</span>
                    <span class="prompt" v-else>\{{title}}</span>
                  </span>
                    <span>{{inputCommand}}</span>
                    <span :class="lastLineClass" v-html="lastLineContent"></span>
                    <input
                            v-model="inputCommand"
                            :disabled="lastLineContent!=='&nbsp'"
                            autofocus="true"
                            type="text"
                            @keyup="handleCommand($event)"
                            ref="inputBox"
                            class="input-box">
                </p>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        name: 'VueTerminal',
        data() {
            return {
                messageList: [],
                actionResult: '',
                lastLineContent: '...',
                inputCommand: '',
                supportingCommandList: '',
                historyIndex: 0,
                commandHistory: []
            };
        },
        props: {
            commandList: {
                required: false,
                default: () => ({})
            },
            taskList: {
                required: false,
                default: () => ({})
            },
            title: {
                required: false,
                type: String,
                default: 'vTerminal'
            },
            greeting: {
                required: false,
                type: String,
                default: undefined
            },
            defaultTaskCommandd: {
                required: false,
                type: String,
                default: 'init vTerminal'
            },
            defaultTask: {
                required: false,
                type: String,
                default: undefined
            },
            prompt: {
                required: false,
                default: undefined
            },
            showHelpMessage: {
                required: false,
                default: true
            },
            unknownCommandMessage: {
                required: false,
                default: undefined
            }
        },
        computed: {
            lastLineClass() {
                if (this.lastLineContent === '&nbsp') {
                    return 'cursor'
                } else if (this.lastLineContent === '...') {
                    return 'loading'
                }
            }
        },
        created() {
            this.supportingCommandList = Object.keys(this.commandList).concat(Object.keys(this.taskList))
        },
        async mounted() {
            if (this.defaultTask) {
                await this.handleRun(this.defaultTask)
            }
            if (this.showHelpMessage) {
                this.pushToList({ level: 'System', message: 'Type "help" to get a supporting command list.' })
            }
            this.lastLineContent = '&nbsp'
            this.handleFocus()
        },
        methods: {
            handleFocus() {
                this.$refs.inputBox.focus();
            },
            handleCommand(e) {
                if (e.keyCode !== 13) {
                    this.handlekeyEvent(e)
                    return
                }
                this.commandHistory.push(this.inputCommand)
                this.historyIndex = this.commandHistory.length
                if (typeof this.prompt !== 'undefined') {
                    this.pushToList({ message: `${this.prompt} ${this.inputCommand} ` })
                } else {
                    this.pushToList({ message: `$ \\${this.title} ${this.inputCommand} ` })
                }
                if (!this.inputCommand) return;
                const commandArr = this.inputCommand.split(' ')
                if (commandArr[0] === 'help') {
                    this.printHelp(commandArr[1])
                }else if (commandArr[0] === 'clear') {
                    this.clearList()
                } else if (this.commandList[this.inputCommand]) {
                    this.commandList[this.inputCommand].messages.map(item => this.pushToList(item))
                } else if (this.taskList[this.inputCommand.split(' ')[0]]) {
                    this.handleRun(this.inputCommand.split(' ')[0], this.inputCommand)
                } else {
                    if (this.unknownCommandMessage) {
                        this.pushToList(this.unknownCommandMessage)
                    } else {
                        this.pushToList({ level: 'System', message: '--Unknown Command.' })
                        this.pushToList({ level: 'System', message: '--type "help" to get a supporting command list.' })
                    }
                }
                this.inputCommand = ''
                this.autoScroll()
                this.handleFocus()
            },
            handlekeyEvent(e) {
                switch (e.keyCode) {
                    case 38:
                        this.historyIndex = this.historyIndex === 0 ? 0 : this.historyIndex - 1
                        this.inputCommand = this.commandHistory[this.historyIndex]
                        break;
                    case 40:
                        this.historyIndex = this.historyIndex === this.commandHistory.length ? this.commandHistory.length : this.historyIndex + 1
                        this.inputCommand = this.commandHistory[this.historyIndex]
                        break;
                    default:
                        break;
                }
            },
            handleRun(taskName, input) {
                if (!this.taskList[taskName] || !this.taskList[taskName][taskName]) return Promise.resolve()
                this.lastLineContent = '...'
                return this.taskList[taskName][taskName](this.pushToList, input).then(done => {
                    this.pushToList(done)
                    this.lastLineContent = '&nbsp'
                }).catch(error => {
                    this.pushToList(error || { type: 'error', label: 'Error', message: 'Something went wrong!' })
                    this.lastLineContent = '&nbsp'
                })
            },
            pushToList(message) {
                this.messageList.push(message)
                this.autoScroll()
            },
            clearList(){
                this.messageList = []
                this.autoScroll()
            },
            printHelp(input) {
                if (!input) {
                    this.pushToList({ message: '--Here is a list of supporting command.' })
                    this.supportingCommandList.map(command => {
                        if (this.commandList[command]) {
                            this.pushToList({ type: 'success', label: command, message: '---> ' + this.commandList[command].description })
                        } else {
                            this.pushToList({ type: 'success', label: command, message: '---> ' + this.taskList[command].description })
                        }
                        return undefined
                    })
                    this.pushToList({ message: '--Enter help <command> to get help for a particular command.' })
                } else {
                    const command = this.commandList[input] || this.taskList[input]
                    this.pushToList({ message: command.description })
                }
                this.autoScroll()
            },
            time() {
                return new Date().toLocaleTimeString().split('').splice(2).join('')
            },
            autoScroll() {
                window.scrollTo(0, this.$refs.terminalLastLine.offsetTop);
                const that = this;
                setTimeout(() => {
                    that.handleFocus()
                }, 500)
            }
        }
    };
</script>

<style scoped lang="scss">
    .vue-terminal {
        position: relative;
        width: 100%;
        color: #4CAF50;
    }
    .vue-terminal .terminal-window {
        overflow:hidden;
        z-index:1;
        font: 1.3rem Inconsolata, monospace;
        color: #4CAF50;
        pre {
            font: 1.3rem Inconsolata, monospace;
            white-space: pre-wrap;
        }
        p {
            overflow-wrap: break-word;
            word-break: break-all;
            font-size: 1.3rem;
            .cmd {
                line-height: 24px;
            }
            .info {
                padding: 2px 3px;
                background: #2980b9;
                color: white;
            }
            .warning {
                padding: 2px 3px;
                background: #f39c12;
                color: white;
            }
            .success {
                padding: 2px 3px;
                background: #4caf50;
                color: white;
            }
            .error {
                padding: 2px 3px;
                background: #c0392b;
                color: white;
            }
            .system {
                padding: 2px 3px;
                background: #bdc3c7;
                color: white;
            }
        }
        pre {
            display: inline;
        }
    }
    .vue-terminal .terminal-window .prompt::before {
        margin-right: 10px;
    }
    .vue-terminal .terminal-window .cursor {
        margin: 0;
        background-color: white;
        animation: blink 1s step-end infinite;
        -webkit-animation: blink 1s step-end infinite;
        margin-left: -5px;
    }
    @keyframes blink {
        50% {
            visibility: hidden;
        }
    }
    @-webkit-keyframes blink {
        50% {
            visibility: hidden;
        }
    }
    .vue-terminal .terminal-window .loading {
        display: inline-block;
        width: 0;
        overflow: hidden;
        overflow-wrap: normal;
        animation: load 1.2s step-end infinite;
        -webkit-animation: load 1.2s step-end infinite;
    }
    @keyframes load {
        0% {
            width: 0px;
        }
        20% {
            width: 5px;
        }
        40% {
            width: 10px;
        }
        60% {
            width: 15px;
        }
        80% {
            width: 20px;
        }
    }
    @-webkit-keyframes load {
        0% {
            width: 0px;
        }
        20% {
            width: 5px;
        }
        40% {
            width: 10px;
        }
        60% {
            width: 15px;
        }
        80% {
            width: 20px;
        }
    }
    .terminal-last-line {
        font-size: 0;
        word-spacing: 0;
        letter-spacing: 0;
    }
    .input-box {
        position: relative;
        background:  rgb(3, 9, 36);
        border: none;
        width: 1px;
        opacity: 0;
        cursor: default;
    }
    .input-box:focus{
        outline: none;
        border: none;
    }
</style>