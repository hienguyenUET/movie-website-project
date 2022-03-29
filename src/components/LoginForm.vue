<template>
  <web-header />
  <div class="login">
    <h1>Đăng Nhập</h1>
    <div class="components">
      <div class="component-item">
        <input
          type="text"
          name=""
          id="email"
          placeholder="Email đăng nhập"
          v-model="email"
        />
        <span v-if="v$.email.$error">
          {{ v$.email.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item">
        <input
          type="password"
          id="password"
          placeholder="Mật khẩu"
          v-model="password"
        />
        <span v-if="v$.password.$error">
          {{ v$.password.$errors[0].$message }}
        </span>
      </div>
      <div class="component-item" id="btn">
        <button type="button" @click.prevent="submitForm">Đăng nhập</button>
      </div>
      <div class="content-item" id="resetPass">
        <a href="#">Quên mật khẩu</a>
      </div>
    </div>
  </div>
  <web-footer />
  <!-- <facebook-login class="button"
      appId="326022817735322"
      @login="getUserData"
      @logout="onLogout"
      @get-initial-status="getUserData">
    </facebook-login> -->
</template>

<script>
// import facebookLogin from 'facebook-login-vuejs';
import useValidate from "@vuelidate/core";
import { required, email, minLength } from "@vuelidate/validators";
import WebHeader from "./WebHeader.vue";
import WebFooter from "./WebFooter.vue";
export default {
  components: {
    WebHeader,
    WebFooter,
  },
  // methods: {
  //   getUserData() {
  //     this.FB.api('/me', 'GET', { fields: 'id,name,email' },
  //       userInformation => {
  //         this.personalID = userInformation.id;
  //         this.email = userInformation.email;
  //         this.name = userInformation.name;
  //       }
  //     )
  //   },
  //   sdkLoaded(payload) {
  //     this.isConnected = payload.isConnected
  //     this.FB = payload.FB
  //     if (this.isConnected) this.getUserData()
  //   },
  //   onLogin() {
  //     this.isConnected = true
  //     this.getUserData()
  //   },
  //   onLogout() {
  //     this.isConnected = false;
  //   }
  // }
  data() {
    return {
      v$: useValidate(),
      email: "",
      password: "",
    };
  },
  validations() {
    return {
      email: { required, email },
      password: {
        required,
        minLength: minLength(6),
      },
    };
  },
  methods: {
    submitForm(event) {
      event.preventDefault();
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
.login {
  box-sizing: content-box;
  max-width: 500px;
  border: none;
  border-radius: 10px;
  margin: 0 auto;
  margin-top: 100px;
  background: linear-gradient(to bottom right, rgb(223, 119, 209), #1cd1d1);
}
.login input {
  padding-left: 15px;
  margin-top: 20px;
  margin-bottom: 40px;
  width: 460px;
  height: 50px;
  border-radius: 5px;
  border: none;
}
.login button:hover {
  background-color: rgb(58, 190, 58);
}
#btn {
  padding-top: 20px;
  padding-bottom: 40px;
}
.login button {
  text-align: center;
  font-size: 20px;
  width: 460px;
  height: 50px;
  color: #fff;
  background-color: rgb(51, 72, 190);
  border: none;
  border-radius: 5px;
  transition: 0.5s;
}
.login h1 {
  color: #000;
  font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
    "Lucida Sans", Arial, sans-serif;
  text-align: center;
  padding-top: 20px;
  padding-bottom: 10px;
  border-bottom: 2px solid rgb(212, 199, 199);
  width: 430px;
  margin: 20px auto;
}
#resetPass {
  padding-bottom: 20px;
  padding-right: 20px;
  text-align: end;
}
#resetPass a {
  text-decoration: none;
}
span {
  color: rgb(204, 34, 34);
}
</style>
