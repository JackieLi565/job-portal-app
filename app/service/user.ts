import axios from "axios";

const baseURL = `${process.env.DOMAIN}${process.env.USER_SERVICE}`;
const instance = axios.create({
  baseURL,
});
