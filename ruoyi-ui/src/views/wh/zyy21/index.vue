<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="${comment}" prop="日期">
        <el-input
          v-model="queryParams.日期"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="挂账单位">
        <el-input
          v-model="queryParams.挂账单位"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="备注">
        <el-input
          v-model="queryParams.备注"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="购买科室">
        <el-input
          v-model="queryParams.购买科室"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="购买产品">
        <el-input
          v-model="queryParams.购买产品"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="备注1">
        <el-input
          v-model="queryParams.备注1"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="销售员">
        <el-input
          v-model="queryParams.销售员"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="销售单号">
        <el-input
          v-model="queryParams.销售单号"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="销售金额">
        <el-input
          v-model="queryParams.销售金额"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="销帐日期">
        <el-input
          v-model="queryParams.销帐日期"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="销帐金额">
        <el-input
          v-model="queryParams.销帐金额"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="合计">
        <el-input
          v-model="queryParams.合计"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="交票时间">
        <el-input
          v-model="queryParams.交票时间"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="收票人">
        <el-input
          v-model="queryParams.收票人"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="收款方式">
        <el-input
          v-model="queryParams.收款方式"
          placeholder="请输入${comment}"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="${comment}" prop="f16">
        <el-input
          v-model="queryParams.f16"
          placeholder="请输入${comment}"
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
          v-hasPermi="['wh:zyy21:add']"
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
          v-hasPermi="['wh:zyy21:edit']"
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
          v-hasPermi="['wh:zyy21:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wh:zyy21:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="zyy21List" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="${comment}" align="center" prop="日期" />
      <el-table-column label="${comment}" align="center" prop="挂账单位" />
      <el-table-column label="${comment}" align="center" prop="备注" />
      <el-table-column label="${comment}" align="center" prop="购买科室" />
      <el-table-column label="${comment}" align="center" prop="购买产品" />
      <el-table-column label="${comment}" align="center" prop="备注1" />
      <el-table-column label="${comment}" align="center" prop="销售员" />
      <el-table-column label="${comment}" align="center" prop="销售单号" />
      <el-table-column label="${comment}" align="center" prop="销售金额" />
      <el-table-column label="${comment}" align="center" prop="销帐日期" />
      <el-table-column label="${comment}" align="center" prop="销帐金额" />
      <el-table-column label="${comment}" align="center" prop="合计" />
      <el-table-column label="${comment}" align="center" prop="交票时间" />
      <el-table-column label="${comment}" align="center" prop="收票人" />
      <el-table-column label="${comment}" align="center" prop="收款方式" />
      <el-table-column label="${comment}" align="center" prop="f16" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wh:zyy21:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wh:zyy21:remove']"
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
        <el-form-item label="${comment}" prop="日期">
          <el-input v-model="form.日期" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="挂账单位">
          <el-input v-model="form.挂账单位" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="备注">
          <el-input v-model="form.备注" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="购买科室">
          <el-input v-model="form.购买科室" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="购买产品">
          <el-input v-model="form.购买产品" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="备注1">
          <el-input v-model="form.备注1" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="销售员">
          <el-input v-model="form.销售员" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="销售单号">
          <el-input v-model="form.销售单号" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="销售金额">
          <el-input v-model="form.销售金额" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="销帐日期">
          <el-input v-model="form.销帐日期" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="销帐金额">
          <el-input v-model="form.销帐金额" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="合计">
          <el-input v-model="form.合计" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="交票时间">
          <el-input v-model="form.交票时间" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="收票人">
          <el-input v-model="form.收票人" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="收款方式">
          <el-input v-model="form.收款方式" placeholder="请输入${comment}" />
        </el-form-item>
        <el-form-item label="${comment}" prop="f16">
          <el-input v-model="form.f16" placeholder="请输入${comment}" />
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
import { listZyy21, getZyy21, delZyy21, addZyy21, updateZyy21 } from "@/api/wh/zyy21";

export default {
  name: "Zyy21",
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
      zyy21List: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        日期: null,
        挂账单位: null,
        备注: null,
        购买科室: null,
        购买产品: null,
        备注1: null,
        销售员: null,
        销售单号: null,
        销售金额: null,
        销帐日期: null,
        销帐金额: null,
        合计: null,
        交票时间: null,
        收票人: null,
        收款方式: null,
        f16: null
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
      listZyy21(this.queryParams).then(response => {
        this.zyy21List = response.rows;
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
        日期: null,
        挂账单位: null,
        备注: null,
        购买科室: null,
        购买产品: null,
        备注1: null,
        销售员: null,
        销售单号: null,
        销售金额: null,
        销帐日期: null,
        销帐金额: null,
        合计: null,
        交票时间: null,
        收票人: null,
        收款方式: null,
        f16: null
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
      this.ids = selection.map(item => item.日期)
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
      const 日期 = row.日期 || this.ids
      getZyy21(日期).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改bills";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.日期 != null) {
            updateZyy21(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addZyy21(this.form).then(response => {
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
      const 日期s = row.日期 || this.ids;
      this.$modal.confirm('是否确认删除bills编号为"' + 日期s + '"的数据项？').then(function() {
        return delZyy21(日期s);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wh/zyy21/export', {
        ...this.queryParams
      }, `zyy21_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
