<template>
  <!-- <el-carousel interval="2000" type="card" height="700px">
    <el-carousel-item v-for="item in imgData" :key="item">
      <img :src="item.url" alt="" />
    </el-carousel-item>
  </el-carousel> -->

  <el-calendar>
    <template #date-cell="{ data }">
      <p :class="data.isSelected ? 'is-selected' : ''">
        {{ data.day.split("-").slice(1).join("-") }}
        {{ data.isSelected ? "✔️" : "" }}
      </p>
    </template>
  </el-calendar>
</template>

<script setup>
</script>

<style scoped>
img {

  width: 100%;
  height: 100%;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.is-selected {
  color: #1989fa;
}
</style>