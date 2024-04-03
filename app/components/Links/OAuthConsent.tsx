import { getOAuthConsentURL } from "@/utils/oauth";
import Link from "next/link";
import { FC } from "react";

const OAuthConsentLink: FC = () => {
  const consentURL = getOAuthConsentURL();
  return (
    <Link
      href={consentURL}
      className="block text-white text-center w-full py-2 px-4 bg-secondary rounded-md hover:bg-background transition-colors focus:outline-none"
    >
      Sign in with Google
    </Link>
  );
};

export default OAuthConsentLink;
