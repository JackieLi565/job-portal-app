import axios from "axios";

const baseURL = `${process.env.DOMAIN}${process.env.AUTH_SERVICE}`;
const instance = axios.create({
  baseURL,
});
