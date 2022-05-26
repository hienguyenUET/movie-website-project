<template>
  <!-- <web-header /> -->
  <div class="login">
    <h1>Đăng Nhập</h1>
    <form @submit.prevent="submitForm" class="components">
      <div class="component-item">
        <input
          type="text"
          name=""
          id="email"
          placeholder="Email đăng nhập"
          v-model="state.username"
        />
        <!-- <span v-if="v$.email.$error">
          {{ v$.email.$errors[0].$message }}
        </span> -->
      </div>
      <div class="component-item">
        <input
          type="password"
          id="password"
          placeholder="Mật khẩu"
          v-model="state.password"
        />
        <span v-if="v$.password.$error">
          {{ v$.password.$errors[0].$message }}
        </span>
      </div>
      <p v-if="checked === 3" :class="{ error: checked === 3 }">
        Tài khoản hoặc mật khẩu không chính xác
      </p>
      <p v-if="errMsg">{{ errMsg }}</p>
      <div class="component-item" id="btn">
        <button @click="checkLogin" type="submit">Đăng nhập</button>
      </div>
      <div class="component-item" id="btn1">
        <a id="fb" @click="fbLogin">
          Đăng nhập với Facebook
          <svg
            xmlns="http://www.w3.org/2000/svg"
            width="16"
            height="16"
            fill="currentColor"
            class="bi bi-facebook"
            viewBox="0 0 16 16"
          >
            <path
              d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"
            />
          </svg>
        </a>
      </div>
      <div class="change-route">
        <span>Bạn chưa có tài khoản?</span>
        <span><router-link id="route" to="/signup">Đăng Ký</router-link></span>
      </div>
    </form>
  </div>
  <web-footer />
</template>

<script>
import useValidate from "@vuelidate/core";
import { required, minLength } from "@vuelidate/validators";
import { computed, reactive, ref } from "vue";
// import WebHeader from "./WebHeader.vue";
import WebFooter from "./WebFooter.vue";
import { getAuth, signInWithPopup, FacebookAuthProvider } from "firebase/auth";
import router from "@/router";
import axios from "axios";
export default {
  components: {
    WebFooter,
  },
  setup() {
    const state = reactive({
      username: "",
      password: "",
    });
    const checked = ref(1);

    const checkLogin = () => {
      axios
        .post("http://localhost:8081/auth/login", {
          username: state.username,
          password: state.password,
        })
        .then((res) => {
          localStorage.setItem("token", res.data.token);
          router.push("/");
          checked.value = 2;
        })
        .catch(() => {
          checked.value = 3;
        });
    };

    //LOGIN FACEBOOK
    const auth = getAuth();
    const provider = new FacebookAuthProvider();
    const errMsg = ref();
    const fbLogin = () => {
      signInWithPopup(auth, provider).then(() => {
        router.push("/");
      });
    };

    // LOGIN USER
    // const login = (user) => {
    // signInWithEmailAndPassword(auth, state.username, state.password)
    //   .then(() => {
    //     router.push("/");
    //   })
    //   .catch((error) => {
    //     switch (error.code) {
    //       case "auth/invalid-email":
    //         errMsg.value = "Invalid email";
    //         break;
    //       case "auth/user-not-found":
    //         errMsg.value = "No account with that email was found";
    //         break;
    //       case "auth/wrong-password":
    //         errMsg.value = "Incorrect password";
    //         break;
    //       default:
    //         errMsg.value = "Email or password was incorrect";
    //         break;
    //     }
    //   });
    // };

    //CHECK VALIDATION FORM
    const rules = computed(() => {
      return {
        // username: { required, username },
        password: {
          password: required,
          minLength: minLength(6),
        },
      };
    });

    const v$ = useValidate(rules, state);
    //
    return {
      state,
      v$,
      checkLogin,
      fbLogin,
      errMsg,
      checked,
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
.error {
  color: red;
  text-align: center;
}
label {
  font-size: 20px;
}
.components {
  display: flex;
  flex-direction: column;
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
  background-color: rgb(26, 103, 85);
  border: none;
  border-radius: 5px;
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
.change-route {
  margin-bottom: 30px;
  text-align: center;
}
.component-item span {
  color: rgb(180, 32, 32);
}
p {
  color: rgb(180, 32, 32);
  text-align: center;
  text-transform: uppercase;
  font-weight: 500;
}
#fb {
  width: 300px;
  height: 30px;
  text-decoration: underline;
  color: rgb(64, 64, 188);
  cursor: pointer;
}
#btn1 {
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 20px;
}
#route {
  color: green;
}
</style>
