<template>
    <v-row
        class="price_background"
    >
        <v-container>
            <v-row>
                <v-col cols="5" class="green--text text-left">
                    <h2>{{title}}</h2>
                    <span class="green--text">{{price}}</span>
                    <p class="green--text">{{description}}</p>
                </v-col>
                <v-col cols="7">
                    <v-col v-for="(item, i) in items" :key="i"
                    >
                        <p class="green--text"><v-icon class="green--text">mdi-arrow-up-bold-box-outline</v-icon>{{item}}</p>
                    </v-col>
                </v-col>
            </v-row>
        </v-container>
    </v-row>
</template>
<script>
    export default {
      name: 'AppPrices',
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
      }
    }
</script>
<style scoped>
    .price_background{
        background: transparent;
    }
    .ascii-box {
        white-space: pre-wrap;
    }
</style>