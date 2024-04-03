import Navbar from "@/components/Navigation/Navbar";
import { getJWTPayload } from "@/utils/jwt";
import { redirect } from "next/navigation";
import { FC } from "react";

const Page: FC = () => {
  const session = getJWTPayload();

  if (!session) redirect("/");

  return (
    <main className="flex flex-col bg-background h-screen overflow-y-auto">
      <Navbar session={session} />
      <div className="flex-1 relative"></div>
    </main>
  );
};

export default Page;
