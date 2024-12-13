<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="打印机名称" prop="printername">
        <el-input
          v-model="queryParams.printername"
          placeholder="请输入打印机名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="墨粉盒型号" prop="powdercartridgemodel">
        <el-input
          v-model="queryParams.powdercartridgemodel"
          placeholder="请输入墨粉盒型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="墨粉型号" prop="powdermodel">
        <el-input
          v-model="queryParams.powdermodel"
          placeholder="请输入墨粉型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="硒鼓型号" prop="drummodel">
        <el-input
          v-model="queryParams.drummodel"
          placeholder="请输入硒鼓型号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预估寿命
" prop="drumlife">
        <el-input
          v-model="queryParams.drumlife"
          placeholder="请输入预估寿命
"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驱动下载" prop="driverdownloadurl">
        <el-input
          v-model="queryParams.driverdownloadurl"
          placeholder="请输入驱动下载"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="图片链接" prop="uploadimg">
        <el-input
          v-model="queryParams.uploadimg"
          placeholder="请输入图片链接"
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
          v-hasPermi="['wh:printerdetails:add']"
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
          v-hasPermi="['wh:printerdetails:edit']"
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
          v-hasPermi="['wh:printerdetails:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['wh:printerdetails:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="printerdetailsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="打印机id" align="center" prop="printerid" />
      <el-table-column label="打印机名称" align="center" prop="printername" />
      <el-table-column label="耗材类型" align="center" prop="consumabletype" />
      <el-table-column label="墨粉盒型号" align="center" prop="powdercartridgemodel" />
      <el-table-column label="墨粉型号" align="center" prop="powdermodel" />
      <el-table-column label="硒鼓型号" align="center" prop="drummodel" />
      <el-table-column label="预估寿命
" align="center" prop="drumlife" />
      <el-table-column label="重置方法" align="center" prop="resetmethod" />
      <el-table-column label="其他注意事项" align="center" prop="additionalnotes" />
      <el-table-column label="驱动下载" align="center" prop="driverdownloadurl" />
      <el-table-column label="图片链接" align="center" prop="uploadimg" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['wh:printerdetails:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['wh:printerdetails:remove']"
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

    <!-- 添加或修改printerdetails对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="打印机名称" prop="printername">
          <el-input v-model="form.printername" placeholder="请输入打印机名称" />
        </el-form-item>
        <el-form-item label="墨粉盒型号" prop="powdercartridgemodel">
          <el-input v-model="form.powdercartridgemodel" placeholder="请输入墨粉盒型号" />
        </el-form-item>
        <el-form-item label="墨粉型号" prop="powdermodel">
          <el-input v-model="form.powdermodel" placeholder="请输入墨粉型号" />
        </el-form-item>
        <el-form-item label="硒鼓型号" prop="drummodel">
          <el-input v-model="form.drummodel" placeholder="请输入硒鼓型号" />
        </el-form-item>
        <el-form-item label="预估寿命
" prop="drumlife">
          <el-input v-model="form.drumlife" placeholder="请输入预估寿命
" />
        </el-form-item>
        <el-form-item label="重置方法" prop="resetmethod">
          <el-input v-model="form.resetmethod" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="其他注意事项" prop="additionalnotes">
          <el-input v-model="form.additionalnotes" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="驱动下载" prop="driverdownloadurl">
          <el-input v-model="form.driverdownloadurl" placeholder="请输入驱动下载" />
        </el-form-item>
        <el-form-item label="图片链接" prop="uploadimg">
          <el-input v-model="form.uploadimg" placeholder="请输入图片链接" />
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
import { listPrinterdetails, getPrinterdetails, delPrinterdetails, addPrinterdetails, updatePrinterdetails } from "@/api/wh/printerdetails";

export default {
  name: "Printerdetails",
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
      // printerdetails表格数据
      printerdetailsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        printername: null,
        consumabletype: null,
        powdercartridgemodel: null,
        powdermodel: null,
        drummodel: null,
        drumlife: null,
        resetmethod: null,
        additionalnotes: null,
        driverdownloadurl: null,
        uploadimg: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        printername: [
          { required: true, message: "打印机名称不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询printerdetails列表 */
    getList() {
      this.loading = true;
      listPrinterdetails(this.queryParams).then(response => {
        this.printerdetailsList = response.rows;
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
        printerid: null,
        printername: null,
        consumabletype: null,
        powdercartridgemodel: null,
        powdermodel: null,
        drummodel: null,
        drumlife: null,
        resetmethod: null,
        additionalnotes: null,
        driverdownloadurl: null,
        uploadimg: null
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
      this.ids = selection.map(item => item.printerid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加printerdetails";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const printerid = row.printerid || this.ids
      getPrinterdetails(printerid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改printerdetails";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.printerid != null) {
            updatePrinterdetails(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPrinterdetails(this.form).then(response => {
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
      const printerids = row.printerid || this.ids;
      this.$modal.confirm('是否确认删除printerdetails编号为"' + printerids + '"的数据项？').then(function() {
        return delPrinterdetails(printerids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('wh/printerdetails/export', {
        ...this.queryParams
      }, `printerdetails_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
