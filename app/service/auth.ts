import axios from "axios";

const baseURL = `http://${process.env.NEXT_PUBLIC_DOMAIN}${process.env.NEXT_PUBLIC_AUTH_SERVICE}`;
const instance = axios.create({
  baseURL,
});
