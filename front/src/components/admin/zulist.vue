<template>
  <div class="header">
    <el-form :inline="true" :model="form" class="demo-form-inline">
      <span style="margin-right: 150px">在租列表</span>
      <el-form-item label="物品名称:">
        <el-input v-model="form.search" placeholder="搜索" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <br />
    <el-button @click="shuaxin()">
      <el-icon size="30"><Refresh /></el-icon>
    </el-button>
  </div>
  <div class="wrapper">
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      empty-text="还没有租客租赁物品"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        align="center"
        prop="item_id"
        label="物品ID"
        width="100"
      />
      <el-table-column align="center" prop="iname" label="地址" width="180" />
      <el-table-column align="center" prop="price" label="价格" />
      <el-table-column align="center" prop="userlist.nickname" label="租赁人" />
      <el-table-column
        align="center"
        prop="userlist.idcard"
        label="租赁人身份证号"
      />
      <el-table-column
        align="center"
        width="150"
        prop="userlist.phone"
        label="租赁人联系电话"
      />
      <el-table-column align="center" label="操作">
        <template #default="scope">
          <el-button size="small" @click="handleEdit(scope.$index, scope.row)"
            >查看合同</el-button
          >
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)"
            >终止合同</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
  <div class="block">
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="cur"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    >
    </el-pagination>
  </div>
</template>
  
<script setup>
import { reactive, ref, onMounted } from "vue";
import { get, post } from "@/api/request";
import { ElMessage } from "element-plus";
import router from "@/router";

import { adminStore } from "@/store/index";
const itemlist = adminStore();

const form = reactive({
  search: "",
});
// 刷新
const shuaxin = () => {
  form.search = "";
  getData();
};
// 查询
const onSubmit = () => {
  console.log(form.search);
  console.log("点击查询");
  getData();
};
const tableData = ref([]);
// 分页数据
const total = ref(100), //数据总数
  size = ref(10), //每页的数据条数
  cur = ref(1); //当前页
// 表格数据
const getData = async () => {
  console.log(cur.value + "<=====cur");
  console.log(size.value + "<=====size");
  console.log(total.value + "<=====total");
  get("/api/zulist", {
    search: form.search,
    cur: cur.value,
    size: size.value,
  }).then((resp) => {
    console.log(resp);
    let data = resp.list;
    tableData.value = data;
    total.value = resp.total; //总页数
  });
};
// 表格全选
const multipleSelection = ref([]);
const handleSelectionChange = (val) => {
  multipleSelection.value = val;
  console.log(val);
};
// 点击查看合同
const handleEdit = (index, row) => {
  get("/api/findHetong", {
    item_id: row.item_id,
  }).then((resp) => {
    console.log(resp);
    if (resp.code == 200) {
      itemlist.changeRowData(resp.data);
    }
  });
  router.push("/hetong");
  console.log(index, row);
};
//终止合同
const handleDelete = (index, row) => {
  alert("卖家");

  get("/api/deletehetong", { item_id: row.item_id })
    .then((resp) => {
      if (resp.code == 200) {
        getData();
        ElMessage.success(resp.message);
      }
    })
    .catch((msg) => {
      console.log(msg);
    });
};
// 分页
function handleSizeChange(val) {
  size.value = val;
  getData();
  console.log(`每页 ${val} 条`);
}
function handleCurrentChange(val) {
  cur.value = val;
  getData();
  console.log(`当前页: ${val}`);
}
// 初始化表格数据
onMounted(() => {
  getData();
});
</script>
  <style scoped>
.header {
  border: 1px solid #eee;
  padding: 10px;
  border-radius: 6px;
}
.el-form-item {
  margin-bottom: 0;
}
</style>
  