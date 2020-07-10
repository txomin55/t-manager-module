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
            <p>
              {{$t('home.projectMotivation.p1')}}
            </p>
            <p>
              {{$t('home.projectMotivation.p2')}}
            </p>
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
            <AppProjectSpecs :title="$t('home.projectFeatures.architecture')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs :title="$t('home.projectFeatures.internationalization')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs :title="$t('home.projectFeatures.exceptionHandling')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs :title="$t('home.projectFeatures.authentication')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs :title="$t('home.projectFeatures.security')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs :title="$t('home.projectFeatures.documentation')" text="--Short description for the ones who look for something new. Awesome!"/>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section :style="{background:appColors.grey.lighten3}">
      <v-container>
        <v-row>
          <v-col class="text-center">
            <h2>{{$t('home.pricingPlans')}}</h2>
            <p>--Stop wasting time and money designing...</p>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon :title="$t('home.pricingPlans.reinforcement')" price="10€/h" description="--Aprende a programar" :items="['asdfsdfsd', 'fasdfasdf']"/>
          </v-col>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon :title="$t('home.pricingPlans.poc')" price="1000€" description="--¿Necesitas alguna prueba de concepto?" :items="['asdfsdfsd', 'fasdfasdf']"/>
          </v-col>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon :title="$t('home.pricingPlans.web')" price="500€" description="--Creación de páginas web" :items="['asdfsdfsd', 'fasdfasdf', 'fasdfasdf']"/>
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
                  src="https://cdn.vuetifyjs.com/images/john.jpg"
                  alt="John"
              >
            </v-avatar>
          </v-col>
          <v-col cols="12" class="text-center">
            <p>--INFORMACION SOBRE QUIEN SOY RESUMIDO</p>
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
