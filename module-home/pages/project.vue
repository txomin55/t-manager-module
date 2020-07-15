<template>
  <v-container>
      <h2>T-MANAGER MODULE</h2>
      <v-row>
          <v-col>
              <v-card>
                  <v-tabs
                      v-model="tab"
                      vertical
                  >
                      <v-tab
                              v-for="item in items"
                              :key="item.tab"
                      >
                          {{ $t(item.tab) }}
                      </v-tab>

                      <v-tab-item
                              v-for="item in items"
                              :key="item.tab"
                      >
                          <v-card flat>
                              <v-card-text><p v-html="$t(item.content)"></p></v-card-text>
                          </v-card>
                      </v-tab-item>
                  </v-tabs>

              </v-card>
          </v-col>
      </v-row>
  </v-container>
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
