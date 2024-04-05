import axios from "axios";

const baseURL = `${process.env.NEXT_PUBLIC_DOMAIN}${process.env.NEXT_PUBLIC_USER_SERVICE}`;
const instance = axios.create({
  baseURL,
});
