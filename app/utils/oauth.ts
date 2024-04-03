export const getOAuthConsentURL = () => {
  const ROOT = "https://accounts.google.com/o/oauth2/v2/auth";
  const options = {
    redirect_uri: process.env.OAUTH_REDIRECT_URI,
    client_id: process.env.OAUTH_CLIENT_ID,
    access_type: "offline",
    response_type: "code",
    promt: "concent",
    scope: "https://www.googleapis.com/auth/userinfo.email",
  };

  const queryParams = new URLSearchParams(options);

  return `${ROOT}?${queryParams}`;
};
