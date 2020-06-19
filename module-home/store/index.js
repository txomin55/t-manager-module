export const state = () => ({
  locales: ['en', 'es'],
  locale: 'es'
})

export const mutations = {
  SET_LANG (state, locale) {
    if (state.locales.includes(locale)) {
      state.locale = locale
    }
  }
}

export const actions = {
  toggleLanguage (context, data) {
    context.commit('SET_LANG', data.locale)
    data.cb(data.locale)
  }
}
