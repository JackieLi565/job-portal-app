import { cookies } from "next/headers";
import { verify } from "jsonwebtoken";

export type JWTPayload = {
  id: string;
  email: string;
  firstName: string;
  lastName: string;
  role: string;
  image: string;
};

export const getJWTPayload = () => {
  const cookieStore = cookies();
  const jwtToken = cookieStore.get("workwise");

  try {
    if (!jwtToken) return undefined;

    const payload = verify(jwtToken.value, process.env.JWT_SECRET);

    return payload as JWTPayload;
  } catch (_) {
    return undefined;
  }
};
