<template>
    <v-card
        outlined
        :color="appColors.blue.base"
        dark
        height="100%"
        max-width="90%"
        class="flexy_card"
    >
        <div class="floating_pricing_baloon">
            <v-img src="baloon-three.svg" class="floating_pricing_baloon__image"></v-img>
        </div>

        <v-card-text>
            <v-container>
                <v-row>
                    <v-col class="white--text text-right">
                        <h2>{{title}}</h2>
                        <span class="white--text price">{{price}}</span>
                        <p class="white--text description">{{description}}</p>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col
                        cols="12"
                        v-for="(item, i) in items" :key="i"
                    >
                        <p class="white--text"><v-icon dark>mdi-arrow-up-bold-box-outline</v-icon> {{item}}</p>
                    </v-col>
                </v-row>
            </v-container>
        </v-card-text>

        <v-card-actions>
            <v-row>
                <v-col class="text-center">
                    <v-btn rounded>--ASK FOR IT</v-btn>
                </v-col>
            </v-row>
        </v-card-actions>

        <AppWaves />
    </v-card>
</template>
<script>
    import colors from 'vuetify/es5/util/colors'
    import AppWaves from './AppWaves'

    export default {
      name: 'AppFloatingBaloon',
      components: {
        AppWaves
      },
      props: {
        title: {
          type: String,
          default: null
        },
        price: {
          type: String,
          default: null
        },
        description: {
          type: String,
          default: null
        },
        items: {
          type: Array,
          default: () => []
        }
      },
      data () {
        return {
          appColors: colors
        }
      }
    }
</script>
<style scoped>
    .flexy_card{
        display: flex;
        flex-direction: column;
        justify-content: space-between;
    }
    .floating_pricing_baloon {
        width: 50%;
        overflow: hidden;
        position: absolute;
        opacity: 0.5;
    }
    .floating_pricing_baloon__image{
        left: -1.5em;
    }
    .price{
        font-size: 2em;
    }
</style>