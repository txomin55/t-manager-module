<template>
  <div>
    <section :class="{ 'smAndUp_header_background': isSMAndUp, 'smAndDown_header_background': !isSMAndUp }">
      <v-container :class="{ 'smAndUp_header_padding': isSMAndUp,  'smAndDown_header_padding': !isSMAndUp}">
        <v-row align="center">
          <v-col cols="12" sm="9">
            <v-text-field
                    label="--email"
                    filled
                    rounded
                    dense
                    hide-details
            ></v-text-field>
          </v-col>
          <v-col cols="12" sm="3" class="text-center">
            <v-btn>
              --Unete
            </v-btn>
          </v-col>
        </v-row>
      </v-container>

    </section>

    <section :style="{background:appColors.grey.lighten3}">
      <v-container>
        <v-row>
          <v-col cols="12" sm="6">
            <v-img src="/about2.svg"></v-img>
          </v-col>
          <v-col cols="12" sm="6">
            --ESCRIBIR LA MOTIVACION DE LA PAGINA
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section>
      <v-container>
        <v-row>
          <v-col class="text-center">
            <h2>--Project features</h2>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Optimized for sharing" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Donation receipts" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Brand and theme" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Video update tool" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Offline management" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
          <v-col cols="12" sm="6">
            <AppProjectSpecs title="--Data & reporting" text="Short description for the ones who look for something new. Awesome!"/>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section :style="{background:appColors.grey.lighten3}">
      <v-container>
        <v-row>
          <v-col>
            <h2>--Pricing Plan</h2>
            <p>--Stop wasting time and money designing...</p>
          </v-col>
        </v-row>
        <v-row>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon title="--Refuerzo" price="--199$" description="--Aprende a programar" :items="['asdfsdfsd', 'fasdfasdf']"/>
          </v-col>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon title="--POC" price="--299$" description="--¿Necesitas alguna prueba de concepto?" :items="['asdfsdfsd', 'fasdfasdf']"/>
          </v-col>
          <v-col cols="12" sm="4">
            <AppFloatingBaloon title="--Webs" price="--399$" description="--Creación de páginas web" :items="['asdfsdfsd', 'fasdfasdf', 'fasdfasdf']"/>
          </v-col>
        </v-row>
      </v-container>
    </section>

    <section>
      <v-container>
        <v-row>
          <v-col cols="12" class="text-center">
            <h2>--Me</h2>
          </v-col>
          <v-col cols="12" class="text-center">
            <v-avatar>
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
  .smAndUp_header_padding{
    width: 50%;
    padding-top: 5em;
  }
  .smAndDown_header_background{
    background-image: url("/header.png");
    background-size: cover;
    height: 10em;
  }
  .smAndDown_header_padding{
    padding-top: 1em;
  }
</style>
