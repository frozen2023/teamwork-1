import Vue from 'vue'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/base.css'
import {
  Avatar,
  Button,
  Input,
  Col,
  Checkbox,
  Form,
  FormItem,
  Link,
  Dropdown,
  DropdownMenu,
  DropdownItem,
  DatePicker,
  Menu,
  MenuItem,
  Row,
  Tabs,
  TabPane,
  Tree,
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

Vue.use(Avatar)
Vue.use(Form)
Vue.use(FormItem)
Vue.use(Button)
Vue.use(Link)
Vue.use(Input)
Vue.use(Checkbox)
Vue.use(Col)
Vue.use(Dropdown)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.use(DatePicker)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(PageHeader)
Vue.use(Progress)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Tree)
Vue.use(Row)
Vue.use(Upload)

Vue.prototype.$message = Message
Vue.prototype.$messageBox = MessageBox
Vue.prototype.$notify = Notification
Vue.prototype.$loading = Loading.service
Vue.prototype.$confirm = MessageBox.confirm
