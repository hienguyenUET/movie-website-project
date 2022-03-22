<template>
  <div class="content">
    <router-view />
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {},
  methods: {},
};
</script>

<style>
.fade-enter-from, .fade-leave-to {
  opacity: 0;
}
.fade-enter-active, .fade-leave-active {
  transition: opacity 0.5s ease-out;;
}
</style>
