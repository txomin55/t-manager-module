<template>
    <div class="header_background">
      <v-container>
          <h2 class="green--text">T-MANAGER MODULE</h2>
          <v-row>
              <v-col>
                  <v-sheet
                    color="transparent"
                    class="project_features"
                  >
                      <v-tabs
                          v-model="tab"
                          vertical
                      >
                          <v-tab
                                  v-for="item in items"
                                  :key="item.tab"
                                  class="green--text"
                          >
                              {{ $t(item.tab) }}
                          </v-tab>

                          <v-tab-item
                                  v-for="item in items"
                                  :key="item.tab"
                          >
                              <v-container>
                                  <p class="green--text" v-html="$t(item.content)"></p>
                              </v-container>
                          </v-tab-item>
                      </v-tabs>

                  </v-sheet>
              </v-col>
          </v-row>
      </v-container>
    </div>
</template>
<script>
    export default {
      data () {
        return {
          tab: 0,
          items: [
            {
              tab: 'project.motivation.title',
              content: 'project.motivation.description'
            },
            {
              tab: 'project.structure.title',
              content: 'project.structure.description'
            },
            {
              tab: 'project.authentication.title',
              content: 'project.authentication.description'
            },
            {
              tab: 'project.frontend.title',
              content: 'project.frontend.description'
            },
            {
              tab: 'project.backend.title',
              content: 'project.backend.description'
            },
            {
              tab: 'project.compilation.title',
              content: 'project.compilation.description'
            },
            {
              tab: 'project.execution.title',
              content: 'project.execution.description'
            }
          ]
        }
      }
    }
</script>
<style>
    .project_features .theme--light.v-tabs > .v-tabs-bar{
        background-color: transparent !important;
    }
    .project_features .theme--light.v-tabs-items{
        background-color: transparent !important;
    }
</style>
