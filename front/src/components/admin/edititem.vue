<template>
  <div class="header">
    <span style="line-height: 30px">更新物品信息</span>
  </div>
  <div class="wrapper">
    <el-form :model="form" label-width="80px" style="width: 300px">
      <el-form-item
        label="物品ID:"
        :rules="[
          { required: true, message: 'ID不能为空' },
          { type: 'number', message: 'ID必须为数字值' },
        ]"
      >
        <el-input v-model="form.itemid" />
      </el-form-item>

      <el-form-item
        label="照片:">
<!--        :rules="[-->
<!--          { required: true, message: '照片不能为空' },-->
<!--          // { type: 'number', message: '面积必须为数字值' },-->
<!--        ]"-->
<!--      >-->
        <el-input v-model="form.photo" type="number" />
      </el-form-item>

      <el-form-item
        label="租金:"
        :rules="[
          { required: true, message: '租金不能为空' },
          { type: 'number', message: '租金必须为数字值' },
        ]"
      >
        <el-input v-model="form.price" />
      </el-form-item>

      <el-form-item label="物品名称:">
<!--        <el-cascader-->
<!--          :placeholder="form.address"-->
<!--          size="default"-->
<!--          :options="regionData"-->
<!--          v-model="form.address"-->
<!--          @change="handleChange"-->
<!--        >-->
<!--        </el-cascader>-->
        <el-input v-model="form.iname"  />
      </el-form-item>
      <el-form-item label="物品详情:">
        <el-input
          v-model="form.detail"
          :autosize="{ minRows: 4, maxRows: 8 }"
          maxlength="100"
          show-word-limit
          type="textarea"
          placeholder="请输入内容"
      /></el-form-item>
      <el-form-item
        label="状态:"
        :rules="[{ required: true, message: '状态不能为空' }]"
      >
        <el-select v-model="form.status" placeholder="请选择">
          <el-option label="未租赁" value="未租赁" />
          <el-option label="已租赁" value="已租赁" />
        </el-select>
      </el-form-item>
    </el-form>

    <div class="btn">
      <el-button
        type="primary"
        @click="submitForm(form)"
        style="margin-right: 50px"
        >提交</el-button
      >
      <el-button type="success" @click="returnLast()">返回</el-button>
    </div>
  </div>
</template>

<script setup>
import { reactive, getCurrentInstance } from "vue";
import { regionData, CodeToText } from "element-china-area-data";
import { adminStore } from "@/store/index";
import router from "@/router";
import { get, post } from "@/api/request";

const itemlist = adminStore();
let { proxy } = getCurrentInstance();
const form = reactive({
  itemid: "",
  photo: "",
  price: "",
  iname: "",
  detail: "",
  status: "",
});
Object.assign(form, itemlist.rowData);
console.log(form);

// const handleChange = (value) => {
//   form.address =
//     CodeToText[value[0]] + CodeToText[value[1]] + CodeToText[value[2]];
//   console.log(value);
// };

const submitForm = async (form) => {
  // form.address += form.dizi;
  // ajax 请求接口
  post("/api/edititem", form)
    .then((resp) => {
      if (resp === 200) {
        ElMessage({
          type: "success",
          message: `更新成功^v^`,
        });
      }
      console.log(resp);
      router.back();
    })
    .catch((msg) => {
      console.log("失败回调==》" + msg);
    });
};
// 返回上一层
const returnLast = () => {
  router.back();
};
</script>
<style scoped>
.header {
  height: 30px;
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 6px;
  margin-bottom: 10px;
}
.wrapper {
  width: 200px;
  height: 200px;
  position: absolute;
  top: 30%;
  left: 50%;
  transform: translate(-50%, -50%);
}
.btn {
  position: absolute;
  transform: translate(50%, 50%);
}
</style>