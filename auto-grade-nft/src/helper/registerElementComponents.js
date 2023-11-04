import Vue from 'vue'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/base.css'
import {
  Button,
  Input,
  Col,
  Checkbox,
  Form,
  FormItem,
  Link,
  DatePicker,
  Menu,
  MenuItem,
  Row,
  PageHeader,
  Progress,
  Upload,
  Container,
  Header,
  Aside,
  Main,
  Notification,
  Message,
  MessageBox,
  Loading
} from 'element-ui'

Vue.use(Form)
Vue.use(FormItem)
Vue.use(Button)
Vue.use(Link)
Vue.use(Input)
Vue.use(Checkbox)
Vue.use(Col)
Vue.use(DatePicker)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(PageHeader)
Vue.use(Progress)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Row)
Vue.use(Upload)

Vue.prototype.$message = Message
Vue.prototype.$messageBox = MessageBox
Vue.prototype.$notify = Notification
Vue.prototype.$loading = Loading.service
Vue.prototype.$confirm = MessageBox.confirm
