<template>
  <div>
    <section :class="{ 'smAndUp_header_background': isSMAndUp, 'smAndDown_header_background': !isSMAndUp }">

    </section>

      <section :style="{background:appColors.grey.lighten3}">
        <v-container>
          <v-row>
            <v-col cols="12" sm="6">
              <v-img src="/about2.svg"></v-img>
            </v-col>
            <v-col cols="12" sm="6">
              <h2>{{$t('home.projectMotivation')}}</h2>
              <div v-html="$t('home.projectMotivation.description')"></div>
            </v-col>
          </v-row>
        </v-container>
      </section>

      <section>
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
      </section>

      <section :style="{background:appColors.grey.lighten3}">
        <v-container>
          <v-row>
            <v-col class="text-center">
              <h2>{{$t('home.pricingPlans')}}</h2>
              <p v-html="$t('home.pricingPlans.description')"></p>
            </v-col>
          </v-row>
          <v-row>
            <v-col cols="12" sm="4">
              <AppFloatingBaloon :title="$t('home.pricingPlans.reinforcement')" price="10€/h" :description="$t('home.pricingPlans.reinforcement.sub')" :items="['asdfsdfsd', 'fasdfasdf']"/>
            </v-col>
            <v-col cols="12" sm="4">
              <AppFloatingBaloon :title="$t('home.pricingPlans.web')" price="500€" :description="$t('home.pricingPlans.web.sub')" :items="['asdfsdfsd', 'fasdfasdf', 'fasdfasdf']"/>
            </v-col>
            <v-col cols="12" sm="4">
              <AppFloatingBaloon :title="$t('home.pricingPlans.poc')" price="1000€" :description="$t('home.pricingPlans.poc.sub')" :items="['asdfsdfsd', 'fasdfasdf']"/>
            </v-col>
          </v-row>
        </v-container>
      </section>

      <section>
        <v-container>
          <v-row>
            <v-col cols="12" class="text-center">
              <h2>{{$t('home.me')}}</h2>
            </v-col>
            <v-col cols="12" class="text-center">
              <v-avatar
                height="10em"
                width="10em"
              >
                <img
                    src="/avatar.jpg"
                    alt="Txomin sirera"
                >
              </v-avatar>
            </v-col>
            <v-col cols="12" class="text-center">
              <div v-html="$t('home.me.description')"></div>
            </v-col>
          </v-row>
        </v-container>
      </section>

    <section :style="{background:appColors.grey.lighten3}">
      <v-container>
        <v-row>
          <v-col cols="12">
            <AppContactForm/>
          </v-col>
        </v-row>
      </v-container>
    </section>

  </div>
</template>
<script>
    import colors from 'vuetify/es5/util/colors'
    import AppFloatingBaloon from '../components/AppFloatingBaloon'
    import AppProjectSpecs from '../components/AppProjectSpecs'
    import AppContactForm from '../components/AppContactForm'

export default {
      components: {
        AppContactForm,
        AppProjectSpecs,
        AppFloatingBaloon
      },
      data () {
        return {
          isSMAndUp: true,
          appColors: colors
        }
      },
      computed: {
        smAndUp () {
          return this.$vuetify.breakpoint.smAndUp
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
<style scoped>
  .smAndUp_header_background{
    background-image: url("/header.png");
    background-size: contain;
    min-height: 80vh;
  }
  .smAndDown_header_background{
    background-image: url("/header.png");
    background-size: cover;
    height: 10em;
  }
</style>
