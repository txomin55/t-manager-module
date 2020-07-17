<template xmlns="http://www.w3.org/1999/html">
  <div style="height: 100%">
    <section class="header_background">

      <span class="green--text">
        {{prompt}} ./bin/execute txomins
      </span>

      <div class="ascii-box">
          <span class="green--text">
  _____                     _                          _
 |_   _|_  _____  _ __ ___ (_)_ __  ___  __      _____| |__  _ __   __ _  __ _  ___
   | | \ \/ / _ \| '_ ` _ \| | '_ \/ __| \ \ /\ / / _ \ '_ \| '_ \ / _` |/ _` |/ _ \
   | |  >  < (_) | | | | | | | | | \__ \  \ V  V /  __/ |_) | |_) | (_| | (_| |  __/
   |_| /_/\_\___/|_| |_| |_|_|_| |_|___/   \_/\_/ \___|_.__/| .__/ \__,_|\__, |\___|
                                                            |_|          |___/
                                                                                   v1.0.1
                                                                                   By Txomin
          </span>
      </div>

      <client-only>

        <div v-for="(typing, i) in titleTexts" :key="i">
          <template v-if="previousCommandEntered(i)">
            <span class="green--text">
              {{prompt}}
            </span>
            <vue-typer
                    :text=typing
                    :repeat=0
                    :shuffle='true'
                    initial-action='typing'
                    :pre-type-delay='1000'
                    :type-delay='50'
                    erase-style='select-all'
                    caret-animation='blink'
                    @completed="onComplete(i)"
            ></vue-typer>
            <br/>
          </template>
        </div>

        <template v-if="lastCommandEntered">
          <div class="green--text">
            <app-vue-terminal
              :task-list="taskList"
              :command-list="commandList"
              :show-header="false"
              default-task-commandd=""
              :prompt="prompt"
              :show-help-message="false"
              :unknown-command-message="unknownCommandMessage"
            />
          </div>
        </template>

      </client-only>
    </section>

    <div style="display:none">
      <div class="ascii-box" ref="about">
            <span class="green--text">
              <v-container>
                <v-row>
                  <v-col cols="12" sm="3">
     !
     ^
    / \
   /___\
  |=   =|
  |     |
  |     |
 /|##!##|\
/ |##!##| \
|/ ^ | ^ \|
   ( | )
  ((   ))
 ((  :  ))
  ((   ))
   (( ))
    ( )
     .
                  </v-col>
                  <v-col cols="12" sm="9">
                    <h2>{{$t('home.projectMotivation')}}</h2>
                    <div v-html="$t('home.projectMotivation.description')"></div>
                  </v-col>
                </v-row>
              </v-container>
            </span>
      </div>
    </div>

      <div style="display:none">
        <div class="ascii-box" ref="features">
          <span class="green--text">
            <v-container>
              <v-row>
                <v-col class="text-center">
                  <h2>{{$t('home.projectFeatures')}}</h2>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.architecture" text="home.projectFeatures.architecture.sub"/>
                </v-col>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.internationalization" text="home.projectFeatures.internationalization.sub"/>
                </v-col>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.exceptionHandling" text="home.projectFeatures.exceptionHandling.sub"/>
                </v-col>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.authentication" text="home.projectFeatures.authentication.sub"/>
                </v-col>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.security" text="home.projectFeatures.security.sub"/>
                </v-col>
                <v-col cols="12" sm="6">
                  <AppProjectSpecs title="home.projectFeatures.documentation" text="home.projectFeatures.documentation.sub"/>
                </v-col>
              </v-row>
            </v-container>
          </span>
        </div>
      </div>

    <div style="display:none">
      <div class="ascii-box" ref="prices">
          <span class="green--text">
            <v-container>
              <v-row>
                <v-col class="text-center">
                  <h2>{{$t('home.pricingPlans')}}</h2>
                  <p v-html="$t('home.pricingPlans.description')"></p>
                </v-col>
              </v-row>
              <v-row>
                <v-col cols="12">
                  <AppPrices :title="$t('home.pricingPlans.reinforcement')" price="10€/h" :description="$t('home.pricingPlans.reinforcement.sub')" :items="['asdfsdfsd', 'fasdfasdf']"/>
                </v-col>
                <v-col cols="12">
                  <AppPrices :title="$t('home.pricingPlans.web')" price="500€" :description="$t('home.pricingPlans.web.sub')" :items="['asdfsdfsd', 'fasdfasdf', 'fasdfasdf']"/>
                </v-col>
                <v-col cols="12">
                  <AppPrices :title="$t('home.pricingPlans.poc')" price="1000€" :description="$t('home.pricingPlans.poc.sub')" :items="['asdfsdfsd', 'fasdfasdf']"/>
                </v-col>
              </v-row>
            </v-container>
          </span>
      </div>
    </div>

    <div style="display:none">
      <div class="ascii-box" ref="txomin">
          <span class="green--text">
            <v-container>
              <v-row>
                <v-col cols="12" class="text-center">
                  <h2>{{$t('home.me')}}</h2>
                </v-col>
                <v-col cols="12" class="text-center">
       _.---._    /\\
    ./'       "--`\//
  ./              o \
 /./\  )______   \__ \
./  / /\ \   | \ \  \ \
   / /  \ \  | |\ \  \7
    "     "    "  "
                </v-col>
                <v-col cols="12" class="text-center">
                  <div v-html="$t('home.me.description')"></div>
                </v-col>
              </v-row>
            </v-container>
          </span>
      </div>
    </div>

  </div>
</template>
<script>
    import colors from 'vuetify/es5/util/colors'
    import AppPrices from '../components/AppPrices'
    import AppProjectSpecs from '../components/AppProjectSpecs'
    import AppVueTerminal from "../components/AppVueTerminal";

export default {
      components: {
        AppProjectSpecs,
        AppPrices,
        AppVueTerminal
      },
      data () {
        return {
          isSMAndUp: true,
          appColors: colors,
          titleTexts: [
            '--Hi this is Txomins webpage',
                  '--Try typing "help" to see the commands and tasks available',
                  '--type "clear" if the console gets too busy'
          ],
          previousCommands: [],
          prompt: "guest@example.com:~$",
          taskList: {
            cd: {
              description:'--Show details: *about *features *prices *txomin',
              cd: (pushToList, input) => {
                const p = new Promise((resolve, reject) => {
                  const url = input.split(' ')[1]

                  if (!url) {
                    reject({ type: 'error', label: 'Error', message: '--A details is required!' })
                    return
                  }

                  pushToList(
                    {
                      message: {
                        list : [
                          {
                            message: this.$refs[url].innerHTML,
                            html: true
                          }
                        ]
                      }
                    }
                  )

                  resolve({ type: 'success', label: 'Done', message: '--Section Opened!' })
                })

                return p;
              }
            }
          },
          commandList: {
            links:{
              description:'--Links',
              messages:[
                { message: '--Email: txomin.sirera@gmail.com' },
                { message: '--Github: https://github.com/txomin55' },
                { message: '--LinkedIn: https://www.linkedin.com/in/txominsirera/' }
              ]
            }
          }
        }
      },
      methods: {
        onComplete (index) {
          if(this.previousCommands.indexOf(index) === -1) {
            this.previousCommands.push(index)
          }
        },
        previousCommandEntered (index) {
          if(index === 0){
            return true
          }

          return this.previousCommands.indexOf(index-1) !== -1
        }
      },
      computed: {
        smAndUp () {
          return this.$vuetify.breakpoint.smAndUp
        },
        lastCommandEntered(){
          return this.previousCommands.length === this.titleTexts.length
        },
        unknownCommandMessage(){
          const date = new Date()

          return {
            time: `${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`,
            type: 'error',
            label: '--Error',
            message: '--That command is not recognized!'
          }
        }
      },
      watch: {
        smAndUp (value) {
          this.isSMAndUp = value
        }
      },
      mounted () {
        this.isSMAndUp = this.$vuetify.breakpoint.smAndUp
      }
    }
</script>
<style>
  .header_background{
    background-color: black;
    background-image: radial-gradient(
            rgba(0, 150, 0, 0.75), black 120%
    );
    height: 100%;
    margin: 0;
    overflow: hidden;
    padding: 2rem;
    color: white;
    font: 1.3rem Inconsolata, monospace;
    text-shadow: 0 0 5px #C8C8C8;
  }
  .header_background::after{
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: repeating-linear-gradient(
            0deg,
            rgba(black, 0.15),
            rgba(black, 0.15) 1px,
            transparent 1px,
            transparent 2px
    );
    pointer-events: none;
  }
  ::selection {
    background: #0080FF;
    text-shadow: none;
  }
  .vue-typer .char.custom {
    color: #4CAF50;
  }
  .vue-typer .char.custom.selected {
    background-color: white;
    color: black;
  }
  .vue-typer .custom.caret {
    width: 10px;
    background-color: white;
  }
  .ascii-box {
    white-space: pre-wrap;
  }
</style>
