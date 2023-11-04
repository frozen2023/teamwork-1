<template>
  <div class="import">
    <div class="import_head">
      <div class="import_head_title">上传文件</div>
      <div class="import_head_confirm" @click="onSubmit()">确认上传</div>
    </div>
    <div class="import_body">
      <el-upload
        class="upload-demo"
        ref="upload"
        drag
        action=""
        :limit="1"
        :on-change="onChange"
        :before-upload="beforeUpload"
        :http-request="uploadFile"
        :auto-upload="false"
        accept=".xlsx"
        multiple
        >
        <i class="el-icon-upload"></i>
        <div class="el-upload__text">拖拽上传你的<em>XSLX</em>文件</div>
      </el-upload>
    </div>
    <div class="import_foot">
        <div class="process_card" v-for="(item) in xlsxList" :key="item.id">
          <div class="process_card_left">
            <img src="@/assets/images/doc.png" alt="">
          </div>
          <div class="process_card_right">
            <div class="process_card_right_title">{{ item.name }}</div>
            <el-progress :percentage="uploadprogressPercentage" :show-text="false"></el-progress>
            <div class="process_card_right_size">{{ (item.size/1024/1024).toFixed(2) }}MB</div>
          </div>
        </div>
      </div>
  </div>
</template>

<script>
import request from '@/utils/request'
export default {
  name: 'gradeIndex',
  components: {},
  data () {
    return {
      xlsxList: [],
      formDate: new FormData(),
      uploadprogressPercentage: 0
    }
  },
  computed: {},
  watch: {},
  methods: {
    async onSubmit() {
      this.$refs.upload.submit()
      this.$message({
        message: "上传中",
        type: "success"
      })
      await request({
        url: 'http://localhost:9000/excel/parse',
        method: "post",
        data: { excel: this.formDate },
        headers: {
          'Content-Type': 'multipart/form-data',
        },
        onUploadProgress: progress => {
          if (progress.event.lengthComputable) {
            this.uploadprogressPercentage = parseInt((progress.loaded / progress.total) * 100) // 进度条百分比
          }
        },
      })
      .then(res => {
        this.text = res.Detail
        this.$message({
          message: "上传成功",
          type: "success"
        })
      })
      .catch(err => {
        this.$message({
          message: "上传失败" + err,
          type: "error"
        })
      })
    },
    beforeUpload(file) {
      console.log("beforeupload")
      console.log(file)
    },
    onChange(file, fileList) {
      console.log("onchange")
      this.xlsxList.push(file)
      console.log(fileList)
    },
    handleExceed() {
      this.$message({
        message: "最多上传1个文件",
        type: "warn"
      })
    },
    uploadFile(file) {
      console.log("uploadfile");
      console.log(file)
      //参数file文件就是传入的文件流，添加进formDate中
      this.formDate.append("file", file.file)
    },
  },
  created () {},
}
</script>
<style scoped lang='less'>
.import {
  padding-left: 17%;
  width: 100%;
  height: 100%;
  text-align: center;
  margin: 0 auto;
}
.import_head {
  float: left;
  height: 18vh;
  width: 60vw;
  &_title {
    text-align: center;
    .px2vh(margin-top, 50);
    color: #000;
    .px2font(37);
    font-weight: 700;
  }
  &_confirm {
    float: left;
    .px2vw(margin-left, 200);
    .px2vh(margin-top, 50);
    color: #000;
    .px2font(22);
    font-weight: 700;
    letter-spacing: 0.12vw;
    cursor: pointer;
  }
}
.import_body {
  .px2vh(padding-top, 17);
  float: left;
  height: 40.7vh;
  width: 60vw;
}
.import_foot{
  .px2vh(padding-top, 17);
  float: left;
  height: 32vh;
  width: 60vw;
  overflow-y: scroll;
  &::-webkit-scrollbar {
		display: none
	}
  .process_card {
    float: left;
    padding-left: 16.5%;
    .px2vh(height, 100);
    width: 100%;
    .px2vh(margin-bottom, 17);
    &_left {
      float: left;
      height: 100%;
      .px2vw(width, 86);
      img {
        .px2vh(height, 98.5);
        .px2vw(width, 86);
      }
    }
    &_right {
      float: left;
      height: 100%;
      .px2vw(width, 670);
      &_title {
        .px2vh(margin-bottom, 15);
        text-align: left;
        color: #000;
        .px2font(20);
        font-weight: 700;
        letter-spacing: 0.1vw;
      }
      &_size {
        .px2vh(margin-top, 17);
        text-align: left;
        color: #9B9595;
        .px2font(16);
        font-weight: 700;
      }
    }
  }
}
::v-deep .el-upload-dragger {
  float: left;
  .px2vw(width, 763);
  .px2vh(height, 425);
  border: 0.1vw dashed #9B9595;
  background: rgba(235, 245, 255, 0.40)
}
::v-deep .el-icon-upload {
  .px2font(100);
  .px2vh(margin-top, 140);
  .px2vh(margin-bottom, 50);
}
.el-upload__text {
  color: #000;
  .px2font(26);
  letter-spacing: 0.15vw;
}
.el-progress-bar {
  background-color: #fff;
}
::v-deep .el-upload-list {
  display: none;
}
::v-deep .el-upload-dragger .el-icon-upload {
  .px2vh(line-height, 60);
}
::v-deep .el-progress-bar__outer {
  .px2vh(height, 11) !important;
}
</style>
