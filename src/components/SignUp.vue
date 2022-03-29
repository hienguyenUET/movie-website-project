<template>
  <web-header/>
  <div class="signup">
    <h1>Đăng Ký</h1>
    <div class="components">
      <div class="component-item">
        <!-- <label for="email">Email đăng ký: </label> -->
        <input
          type="email"
          name=""
          id="email"
          placeholder="Email đăng ký"
          v-model="email"
        />
        <span v-if="v$.email.$error">
          {{ v$.email.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item">
        <input
          type="text"
          name=""
          id="username"
          placeholder="Tên người sử dụng"
          v-model="username"
        />
        <span v-if="v$.username.$error">
          {{ v$.username.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item">

        <input
          type="password"
          id="password"
          placeholder="Mật khẩu"
          v-model="password.password"
        />
        <span v-if="v$.password.password.$error">
          {{ v$.password.password.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item">
        <input
          type="password"
          name=""
          id="passwordAgain"
          placeholder="Nhập lại mật khẩu"
          v-model="password.checkPassword"
        />
        <span v-if="v$.password.checkPassword.$error">
          {{ v$.password.checkPassword.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item" id="checkbox">
        <input type="checkbox" />
        <span>Tôi đồng ý với các điều khoản sử dụng</span>
      </div>
      <div class="component-item" id="btn">
        <button @click="submitForm" type="submit">Đăng ký</button>
      </div>
    </div>
  </div>
  <web-footer/>
</template>

<script>
import useValidate from "@vuelidate/core";
import WebHeader from './WebHeader.vue'
import WebFooter from './WebFooter.vue'
import {
  required,
  email,
  minLength,
  sameAs,
  helpers,
} from "@vuelidate/validators";
const mustHave = (value) => value.includes("@") || value.includes(".");
export default {
  name: 'SignUp',
  components: {WebHeader, WebFooter},
  // setup() {
  //   const state = reactive({
  //     email: "",
  //     password: {
  //       password: "",
  //       checkPassword: "",
  //     }
  //   }),
  //   const rules = computed(() => {
  //     return {
  //       email: { required, email },
  //       password: {
  //         password: { required, minLength: minLength(6) },
  //         checkPassword: { required, sameAs: sameAs(state.password.password) },
  //       }
  //     }
  //   }),
  //   const v$ = useValidate(rules, state)
  //   return {
  //     state,
  //     v$
  //   }
  // },

  data() {
    return {
      v$: useValidate(),
      email: "",
      username: "",
      password: {
        password: "",
        checkPassword: "",
      },
    };
  },
  validations() {
    return {
      email: { required, email },
      username: { required },
      password: {
        password: {
          required,
          minLength: minLength(6),
          mustHave: helpers.withMessage(
            "Your password must include special character(@,.)",
            mustHave
          ),
        },
        checkPassword: {
          required,
          sameAs: sameAs(this.password.password),
        },
      },
    };
  },
  methods: {
    submitForm() {
      this.v$.$validate();
    },
  },
};
</script>
<style scoped>
label {
  font-size: 20px;
}
.components {
  border-top: 2px;
  padding-left: 20px;
}
.signup {
  box-sizing: content-box;
  max-width: 500px;
  border: none;
  border-radius: 10px;
  margin: 0 auto;
  margin-top: 100px;
  background: linear-gradient(to bottom right, rgb(24, 173, 116), #3498db);
}
.signup input {
  padding-left: 15px;
  margin-top: 20px;
  margin-bottom: 20px;
  width: 460px;
  height: 50px;
  border-radius: 5px;
  border: none;
}
.signup input[type="checkbox"] {
  width: auto;
  height: auto;
}
#btn {
  padding-bottom: 40px;
}
.signup button:hover {
  background-color: rgb(94, 94, 226);
}
.signup button {
  text-align: center;
  font-size: 20px;
  width: 460px;
  height: 50px;
  color: #fff;
  background-color: green;
  border: none;
  border-radius: 5px;
  transition: 0.5s;
}
.signup h1 {
  text-align: center;
  padding-top: 20px;
  padding-bottom: 10px;
  border-bottom: 2px solid rgb(212, 199, 199);
  width: 430px;
  margin: 20px auto;
}
.component-item span {
  color: rgb(180, 32, 32);
  text-align: center;
}
#checkbox span {
  color: #000;
}
</style>
