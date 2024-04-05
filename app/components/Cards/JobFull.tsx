"use client";
import { JobPosting, incJobViewCount } from "@/service/job";
import { FC, useEffect } from "react";

type Props = {
  jobData: JobPosting;
};

const JobFullCard: FC<Props> = ({ jobData }) => {
  useEffect(() => {
    const handler = async () => {
      // const _ = await incJobViewCount(jobData.id);
    };

    handler();
  }, [jobData]);

  return (
    <div className="sticky space-y-2 bg-white top-5 h-fit w-[55%] border border-white rounded-md p-5">
      <h1 className="text-2xl mb-1 font-semibold">{jobData.title}</h1>
      <h2 className="text-base text-gray-800">
        {jobData.location} &bull; $ {jobData.pay} per hour
      </h2>

      <div className="p-4 flex items-center justify-between border-b-2 border-accent rounded-md shadow-sm">
        <div className="flex items-center">
          <div className="w-12 h-12 rounded-full bg-background flex items-center justify-center mr-4">
            <img
              className="rounded-full"
              alt="profile picture"
              src="https://lh3.googleusercontent.com/a/ACg8ocKhhhs_UnlSKN8Ug7_Y4EzOyhqav-q14DTG63SlIBd8Suw=s83-c-mo"
            />
          </div>
          <div>
            <p className="font-semibold">{jobData.recruiter.name}</p>
            <p className="text-sm">{jobData.company}</p>
            <p className="text-xs"></p>
          </div>
        </div>
        <button className="px-4 py-2 bg-background text-text text-xs font-semibold rounded-md hover:bg-accent transition-colors">
          View Postings
        </button>
      </div>

      <h1 className="text-xl pt-2 pb-1 font-semibold">Full Job Description</h1>
      <p>{jobData.description}</p>
      <div className="flex justify-end gap-2 pt-1">
        <a
          target="_blank"
          className="rounded-md block px-4 py-1 bg-background text-white"
        >
          Save
        </a>
        <a
          target="_blank"
          href={jobData.url}
          className="rounded-md block px-4 py-1 bg-accent text-text"
        >
          Apply
        </a>
      </div>
    </div>
  );
};

export default JobFullCard;
