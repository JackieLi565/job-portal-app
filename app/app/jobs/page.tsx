import JobContainer from "@/components/Containers/Job";
import Navbar from "@/components/Navigation/Navbar";
import { getJobPostings } from "@/service/job";
import { getJWTPayload } from "@/utils/jwt";
import { redirect } from "next/navigation";
import { FC } from "react";

const Page: FC = () => {
  // const session = getJWTPayload();

  // if (!session) redirect("/");

  return (
    <main className="flex flex-col bg-background h-screen overflow-y-auto">
      <Navbar />
      <div className="flex-1 relative">
        <JobContainer />
      </div>
    </main>
  );
};

export default Page;
