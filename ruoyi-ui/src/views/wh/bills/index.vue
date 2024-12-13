<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="日期" prop="date">
        <el-input
          v-model="queryParams.date"
          placeholder="请输入日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="单位" prop="department">
        <el-input
          v-model="queryParams.department"
          placeholder="请输入单位"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remark1">
        <el-input
          v-model="queryParams.remark1"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="部门" prop="office">
        <el-input
          v-model="queryParams.office"
          placeholder="请输入部门"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品" prop="product">
        <el-input
          v-model="queryParams.product"
          placeholder="请输入产品"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="备注" prop="remark2">
        <el-input
          v-model="queryParams.remark2"
          placeholder="请输入备注"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售人" prop="salesman">
        <el-input
          v-model="queryParams.salesman"
          placeholder="请输入销售人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="订单号" prop="saleno">
        <el-input
          v-model="queryParams.saleno"
          placeholder="请输入订单号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="金额" prop="amount">
        <el-input
          v-model="queryParams.amount"
          placeholder="请输入金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售日期" prop="xzdate">
        <el-input
          v-model="queryParams.xzdate"
          placeholder="请输入销售日期"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="销售金额" prop="xzamout">
        <el-input
          v-model="queryParams.xzamout"
          placeholder="请输入销售金额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="总额" prop="total">
        <el-input
          v-model="queryParams.total"
          placeholder="请输入总额"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="交票时间" prop="jiaoptime">
        <el-input
          v-model="queryParams.jiaoptime"
          placeholder="请输入交票时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检查人" prop="checktaker">
        <el-input
          v-model="queryParams.checktaker"
          placeholder="请输入检查人"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="付款方式" prop="payma">
        <el-input
          v-model="queryParams.payma"
          placeholder="请输入付款方式"
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
          v-hasPermi="['wh:bills:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wh:bills:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wh:bills:remove']"
        >删除</el-button>
      </el-col>
        <el-button
          type="info"
          plain
          icon="el-icon-upload2"
          size="mini"
          @click="handleImport"
          v-hasPermi="['wh:bills:import']"
        >导入账单</el-button>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wh:bills:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="billsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="日期"   sortable align="center" prop="date" />
      <el-table-column label="单位"   sortable align="center" prop="department" />
      <el-table-column label="备注" align="center" prop="remark1" />
      <el-table-column label="部门"   sortable align="center" prop="office" />
      <el-table-column label="产品"   sortable align="center" prop="product" />
      <el-table-column label="备注" align="center" prop="remark2" />
      <el-table-column label="销售人" align="center" prop="salesman" />
      <el-table-column label="订单号" align="center" prop="saleno" />
      <el-table-column label="金额" align="center" prop="amount" />
      <el-table-column label="销售日期"  sortable align="center" prop="xzdate" />
      <el-table-column label="销售金额"  sortable align="center" prop="xzamout" />
      <el-table-column label="总额"  sortable align="center" prop="total" />
      <el-table-column label="交票时间"  sortable align="center" prop="jiaoptime" />
      <el-table-column label="检查人"  sortable  align="center" prop="checktaker" />
      <el-table-column label="付款方式"   sortable align="center" prop="payma" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wh:bills:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wh:bills:remove']"
          >删除</el-button>
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

    <!-- 添加或修改bills对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="日期" prop="date">
          <el-input v-model="form.date" placeholder="请输入日期" />
        </el-form-item>
        <el-form-item label="单位" prop="department">
          <el-input v-model="form.department" placeholder="请输入单位" />
        </el-form-item>
        <el-form-item label="备注" prop="remark1">
          <el-input v-model="form.remark1" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="部门" prop="office">
          <el-input v-model="form.office" placeholder="请输入部门" />
        </el-form-item>
        <el-form-item label="产品" prop="product">
          <el-input v-model="form.product" placeholder="请输入产品" />
        </el-form-item>
        <el-form-item label="备注" prop="remark2">
          <el-input v-model="form.remark2" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="销售人" prop="salesman">
          <el-input v-model="form.salesman" placeholder="请输入销售人" />
        </el-form-item>
        <el-form-item label="订单号" prop="saleno">
          <el-input v-model="form.saleno" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="销售日期" prop="xzdate">
          <el-input v-model="form.xzdate" placeholder="请输入销售日期" />
        </el-form-item>
        <el-form-item label="销售金额" prop="xzamout">
          <el-input v-model="form.xzamout" placeholder="请输入销售金额" />
        </el-form-item>
        <el-form-item label="总额" prop="total">
          <el-input v-model="form.total" placeholder="请输入总额" />
        </el-form-item>
        <el-form-item label="交票时间" prop="jiaoptime">
          <el-input v-model="form.jiaoptime" placeholder="请输入交票时间" />
        </el-form-item>
        <el-form-item label="检查人" prop="checktaker">
          <el-input v-model="form.checktaker" placeholder="请输入检查人" />
        </el-form-item>
        <el-form-item label="付款方式" prop="payma">
          <el-input v-model="form.payma" placeholder="请输入付款方式" />
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
import { listBills, getBills, delBills, addBills, updateBills } from "@/api/wh/bills";

export default {
  name: "Bills",
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
      // bills表格数据
      billsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        date: null,
        department: null,
        remark1: null,
        office: null,
        product: null,
        remark2: null,
        salesman: null,
        saleno: null,
        amount: null,
        xzdate: null,
        xzamout: null,
        total: null,
        jiaoptime: null,
        checktaker: null,
        payma: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询bills列表 */
    getList() {
      this.loading = true;
      listBills(this.queryParams).then(response => {
        this.billsList = response.rows;
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
        date: null,
        department: null,
        remark1: null,
        office: null,
        product: null,
        remark2: null,
        salesman: null,
        saleno: null,
        amount: null,
        xzdate: null,
        xzamout: null,
        total: null,
        jiaoptime: null,
        checktaker: null,
        payma: null
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
      this.ids = selection.map(item => item.date)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加bills";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const date = row.date || this.ids
      getBills(date).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改bills";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.date != null) {
            updateBills(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBills(this.form).then(response => {
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
      const dates = row.date || this.ids;
      this.$modal.confirm('是否确认删除bills编号为"' + dates + '"的数据项？').then(function() {
        return delBills(dates);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wh/bills/export', {
        ...this.queryParams
      }, `bills_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
