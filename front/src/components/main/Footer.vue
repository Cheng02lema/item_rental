<template>
  <div class="footer">
    <div class="left">
      <iframe
        scrolling="no"
        src="http://tianqiapi.com/api.php?style=tu&skin=pitaya&city=蚌埠"
        frameborder="0"
        width="350"
        height="24"
        allowtransparency="true"
      ></iframe>
    </div>
<!--    <div @click="saying()" style="cursor: pointer">-->
<!--      {{ content }} &#45;&#45;{{ author }}-->
<!--    </div>-->
    <div class="right"></div>
  </div>
</template>

<script setup>
import { get } from "@/api/request";
import { onMounted, ref } from "vue";
// 每日一言
const content = ref(),
  author = ref();
const saying = () => {
  get("https://saying.api.azwcl.com/saying/get", {}).then((resp) => {
    content.value = resp.data.content;
    author.value = resp.data.author;
  });
};
// 定时 一分钟刷新
// setInterval(() => {
//   saying();
// }, 1000 * 60);

onMounted(() => {
  // saying();
});
</script>

<style scoped>
.footer {
  height: 50px;
  border-top: 1px solid #e9e9e9;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}
</style>