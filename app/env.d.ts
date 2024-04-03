declare namespace NodeJS {
  export interface ProcessEnv {
    NODE_ENV: "development" | "production";
    DOMAIN: string;
    AUTH_SERVICE: string;
    USER_SERVICE: string;
    JOB_SERVICE: string;
    OAUTH_REDIRECT_URI: string;
    OAUTH_CLIENT_ID: string;
    JWT_SECRET: string;
  }
}
