<template>
    <div>
        <client-only>

            <v-app-bar
              app
              :color="appColors.blue.base"
              dark
            >

              <v-toolbar-title>{{$t('tManager')}}</v-toolbar-title>
              <v-spacer></v-spacer>

              <template v-if="isSMAndUp">
                  <v-btn
                      text
                      v-for="(item, i) in items" :key="i"
                      :to="{ name: item.to }"
                    >
                    {{$t(item.title)}}
                  </v-btn>

                  <v-menu offset-y>
                    <template v-slot:activator="{ on }">
                      <v-btn
                        text
                        v-on="on"
                      >
                        <app-country-flag :country="selectedLanguage" />
                      </v-btn>
                    </template>
                    <v-list>
                      <v-list-item
                        v-for="(item, index) in languages"
                        :key="index"
                        @click="updateLanguage(item)"
                      >
                        <v-list-item-title>{{ item.id.toUpperCase() }}</v-list-item-title>
                      </v-list-item>
                    </v-list>
                  </v-menu>

              </template>

              <template v-else>
                <v-app-bar-nav-icon @click="drawer = !drawer"> </v-app-bar-nav-icon>
              </template>

            </v-app-bar>

            <v-navigation-drawer
              v-if="!isSMAndUp"
              :value="showDrawer"
              app
              elevation="0"
            >
                <v-row v-for="(item, i) in items" :key="i">
                    <v-col cols="12">
                        <v-btn
                            text
                            :to="{ name: item.to }"
                          >
                          {{$t(item.title)}}
                        </v-btn>
                    </v-col>
                </v-row>

                <v-row>
                    <v-col cols="12">
                        <v-menu offset-y>
                            <template v-slot:activator="{ on }">
                              <v-btn
                                text
                                v-on="on"
                              >
                                <app-country-flag :country="selectedLanguage" />
                              </v-btn>
                            </template>
                            <v-list>
                              <v-list-item
                                v-for="(item, index) in languages"
                                :key="index"
                                @click="updateLanguage(item)"
                              >
                                <v-list-item-title>{{ item.id.toUpperCase() }}</v-list-item-title>
                              </v-list-item>
                            </v-list>
                          </v-menu>
                    </v-col>
                </v-row>

            </v-navigation-drawer>

        </client-only>
    </div>
</template>

<script>
import CountryFlag from 'vue-country-flag'
import colors from 'vuetify/es5/util/colors'

export default {
  components: {
    appCountryFlag: CountryFlag
  },
  data () {
    return {
      appColors: colors,
      selectedLanguage: 'es',
      languages: [{ flag: 'es', id: 'es' }, { flag: 'gb', id: 'en' }],
      drawer: false,
      items: [
        { icon: 'apps', title: 'home', to: 'index' },
        { icon: 'bubble_chart', title: 'project', to: 'project' },
        { icon: 'apps', title: 'services', to: 'services' }
      ]
    }
  },
  methods: {
    updateLanguage (item) {
      this.selectedLanguage = item.flag
      this.$store.dispatch('toggleLanguage', {
        locale: item.id,
        cb: locale => {
          this.$i18n.locale = locale
        }
      })
    }
  },
  computed: {
    showDrawer () {
      return this.drawer && !this.isSMAndUp
    },
    isSMAndUp () {
      return this.$vuetify.breakpoint.smAndUp
    }
  }
}
</script>
