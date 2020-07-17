<template>
    <div>

        <v-app-bar
                app
                :color="appColors.black"
                dark
                class="green--text"
        >

              <v-toolbar-title>{{$t('tManager')}}</v-toolbar-title>
              <v-spacer></v-spacer>

              <template v-if="isSMAndUp">
                  <v-btn
                      text
                      v-for="(item, i) in items" :key="i"
                      :to="{ name: item.to }"
                      class="green--text"
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
                class="green--text"
        >
            <v-row v-for="(item, i) in items" :key="i">
                <v-col cols="12">
                    <v-btn
                        text
                        :to="{ name: item.to }"
                        class="green--text"
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
        { icon: 'bubble_chart', title: 'project', to: 'project' }
      ],
      isSMAndUp: true,
      showDrawer: false
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
  mounted () {
    this.isSMAndUp = this.$vuetify.breakpoint.smAndUp
    this.showDrawer = this.drawer && !this.isSMAndUp
  }
}
</script>
