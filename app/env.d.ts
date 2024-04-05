declare namespace NodeJS {
  export interface ProcessEnv {
    NODE_ENV: "development" | "production";
    NEXT_PUBLIC_DOMAIN: string;
    NEXT_PUBLIC_AUTH_SERVICE: string;
    NEXT_PUBLIC_USER_SERVICE: string;
    NEXT_PUBLIC_JOB_SERVICE: string;
    NEXT_PUBLIC_OAUTH_REDIRECT_URI: string;
    NEXT_PUBLIC_OAUTH_CLIENT_ID: string;
    JWT_SECRET: string;
  }
}
