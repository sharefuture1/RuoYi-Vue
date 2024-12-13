<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="楼层及序号" prop="floorserial" sortable>
        <el-input
          v-model="queryParams.floorserial"
          placeholder="请输入楼层及序号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="办公室名称" prop="officename" sortable>
        <el-input
          v-model="queryParams.officename"
          placeholder="请输入办公室名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="打印机名称" prop="printermodel" sortable>
        <el-input
          v-model="queryParams.printermodel"
          placeholder="请输入打印机名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="出厂日期" prop="factorydate" sortable>
        <el-date-picker clearable
                        v-model="queryParams.factorydate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择出厂日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="使用年限" prop="yearsinuse" sortable>
        <el-input
          v-model="queryParams.yearsinuse"
          placeholder="请输入使用年限"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="序列号" prop="serialno">
        <el-input
          v-model="queryParams.serialno"
          placeholder="请输入序列号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资产编码" prop="assetcode">
        <el-input
          v-model="queryParams.assetcode"
          placeholder="请输入资产编码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="组织名称" prop="organizationname" sortable>
        <el-input
          v-model="queryParams.organizationname"
          placeholder="请输入组织名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="统计日期" prop="statsdate">
        <el-date-picker clearable
                        v-model="queryParams.statsdate"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="请选择统计日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="通用编号" prop="universalno" sortable>
        <el-input
          v-model="queryParams.universalno"
          placeholder="请输入通用编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['wh:aorgasset:add']"
        >新增
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wh:aorgasset:edit']"
        >修改
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wh:aorgasset:remove']"
        >删除
        </el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wh:aorgasset:export']"
        >导出
        </el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="aorgassetList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center"/>
      <el-table-column label="打印机ID" align="center" prop="id"/>
      <el-table-column label="楼层及序号"  sortable align="center" prop="floorserial"/>
      <el-table-column label="办公室名称" sortable align="center" prop="officename"/>
      <el-table-column label="打印机名称" sortable  align="center" prop="printermodel"/>
      <el-table-column label="出厂日期"  sortable align="center" prop="factorydate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.factorydate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="使用年限"  sortable align="center" prop="yearsinuse"/>
      <el-table-column label="序列号" align="center" prop="serialno"/>
      <el-table-column label="资产编码" align="center" prop="assetcode"/>
      <el-table-column label="组织名称"  sortable align="center" prop="organizationname"/>
      <el-table-column label="统计日期" align="center" prop="statsdate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.statsdate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="通用编号" align="center" prop="universalno"/>
      <el-table-column label="备注" align="center" prop="remarks"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wh:aorgasset:edit']"
          >修改
          </el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wh:aorgasset:remove']"
          >删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改打印机资产查询对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="楼层及序号" prop="floorserial">
          <el-input v-model="form.floorserial" placeholder="请输入楼层及序号"/>
        </el-form-item>
        <el-form-item label="办公室名称" prop="officename">
          <el-input v-model="form.officename" placeholder="请输入办公室名称"/>
        </el-form-item>
        <el-form-item label="打印机名称" prop="printermodel">
          <el-input v-model="form.printermodel" placeholder="请输入打印机名称"/>
        </el-form-item>
        <el-form-item label="出厂日期" prop="factorydate">
          <el-date-picker clearable
                          v-model="form.factorydate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择出厂日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="使用年限" prop="yearsinuse">
          <el-input v-model="form.yearsinuse" placeholder="请输入使用年限"/>
        </el-form-item>
        <el-form-item label="序列号" prop="serialno">
          <el-input v-model="form.serialno" placeholder="请输入序列号"/>
        </el-form-item>
        <el-form-item label="资产编码" prop="assetcode">
          <el-input v-model="form.assetcode" placeholder="请输入资产编码"/>
        </el-form-item>
        <el-form-item label="组织名称" prop="organizationname">
          <el-input v-model="form.organizationname" placeholder="请输入组织名称"/>
        </el-form-item>
        <el-form-item label="统计日期" prop="statsdate">
          <el-date-picker clearable
                          v-model="form.statsdate"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择统计日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="通用编号" prop="universalno">
          <el-input v-model="form.universalno" placeholder="请输入通用编号"/>
        </el-form-item>
        <el-form-item label="备注" prop="remarks">
          <el-input v-model="form.remarks" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {addAorgasset, delAorgasset, getAorgasset, listAorgasset, updateAorgasset} from "@/api/wh/aorgasset";

export default {
  name: "Aorgasset",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 打印机资产查询表格数据
      aorgassetList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        floorserial: null,
        officename: null,
        printermodel: null,
        factorydate: null,
        yearsinuse: null,
        serialno: null,
        assetcode: null,
        organizationname: null,
        statsdate: null,
        universalno: null,
        remarks: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {}
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询打印机资产查询列表 */
    getList() {
      this.loading = true;
      listAorgasset(this.queryParams).then(response => {
        this.aorgassetList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        floorserial: null,
        officename: null,
        printermodel: null,
        factorydate: null,
        yearsinuse: null,
        serialno: null,
        assetcode: null,
        organizationname: null,
        statsdate: null,
        universalno: null,
        remarks: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length !== 1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加打印机资产查询";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAorgasset(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改打印机资产查询";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAorgasset(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAorgasset(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除打印机资产查询编号为"' + ids + '"的数据项？').then(function () {
        return delAorgasset(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {
      });
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wh/aorgasset/export', {
        ...this.queryParams
      }, `aorgasset_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
