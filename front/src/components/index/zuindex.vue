<template xmlns="">

<zuHeader/>
<zuList/>

</template>


<script setup>
import {useRouter} from "vue-router";
import {onMounted, reactive} from "vue";


const router = useRouter();
const state = reactive({
  name: "",
});

onMounted(() => {
  let str = window.sessionStorage.getItem("token-U");
  let user = JSON.parse(str);
  state.name = user.nickname;
});

// export default {
//
// }

</script>
<style lang="scss" scoped>

</style>