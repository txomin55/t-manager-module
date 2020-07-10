<template>
  <v-form v-model="valid">
    <v-container class="text-center">
      <h2>{{$t('home.reachMe')}}</h2>
      <v-row>
        <v-col
                cols="12"
                sm="6"
        >
          <v-text-field
                  v-model="email"
                  :rules="emailRules"
                  :label="$t('home.mail')"
                  required
          ></v-text-field>
        </v-col>
      </v-row>

      <v-row>
        <v-col
                cols="12"
                sm="6"
        >
          <v-text-field
                  v-model="firstname"
                  :rules="nameRules"
                  :counter="10"
                  :label="$t('home.firstName')"
                  required
          ></v-text-field>
        </v-col>

        <v-col
                cols="12"
                sm="6"
        >
          <v-text-field
                  v-model="lastname"
                  :rules="nameRules"
                  :counter="10"
                  :label="$t('home.lastName')"
                  required
          ></v-text-field>
        </v-col>
      </v-row>

      <v-row>
        <v-col cols="12">
          <v-textarea
                  solo
                  name="input-7-4"
                  :label="$t('home.yourText')"
                  v-model="text"
          ></v-textarea>
        </v-col>
        <v-col cols="12">
          <v-btn rounded>{{$t('home.contact')}}</v-btn>
        </v-col>
      </v-row>

    </v-container>
  </v-form>
</template>
<script>
    export default {
      name: 'AppContactForm',
      data: () => ({
        valid: false,
        firstname: '',
        lastname: '',
        nameRules: [
          v => !!v || 'Name is required',
          v => v.length <= 10 || 'Name must be less than 10 characters'
        ],
        email: '',
        text: '',
        emailRules: [
          v => !!v || 'E-mail is required',
          v => /.+@.+/.test(v) || 'E-mail must be valid'
        ]
      })
    }
</script>
