<template>
  <v-container class="services-container">
      <v-row class="services-container">
          <v-col cols="12" sm="4" v-for="(item, i) in items" :key="i">
              <v-card
                  outlined
                  height="100%"
              >
                  <v-card-text style="height: 75%">
                      <v-container>
                          <v-row>
                              <v-col>
                                  <h2>{{$t(item.title)}}</h2>
                                  <span class="price">{{item.price}}</span>
                                  <p class="description">{{$t(item.description)}}</p>
                              </v-col>
                          </v-row>
                          <v-row>
                              <v-col
                                  cols="12"
                              >
                                  <p><v-icon dark>mdi-arrow-up-bold-box-outline</v-icon> {{$t(item.itemText)}}</p>
                              </v-col>
                          </v-row>
                      </v-container>
                  </v-card-text>

                  <v-card-actions>
                      <v-row>
                          <v-col class="text-center">
                              <v-btn rounded>{{$t("home.pricingPlans.askForIt")}}</v-btn>
                          </v-col>
                      </v-row>
                  </v-card-actions>

              </v-card>
          </v-col>
      </v-row>
  </v-container>
</template>
<script>
    export default {
      data () {
        return {
          items: [
            {
              title: 'home.pricingPlans.reinforcement',
              price: '10€/h',
              description: 'home.pricingPlans.reinforcement.sub',
              itemText: '--1'
            },
            {
              title: 'home.pricingPlans.web',
              price: '500€',
              description: 'home.pricingPlans.web.sub',
              itemText: '--2'
            },
            {
              title: 'home.pricingPlans.poc',
              price: '1000€',
              description: 'home.pricingPlans.poc.sub',
              itemText: '--3'
            }
          ]
        }
      }
    }
</script>
<style scoped>
    .services-container{
        height: 100%;
    }
</style>
