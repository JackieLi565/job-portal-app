"use client";
import { JobPosting } from "@/service/job";
import { useSearchParams } from "next/navigation";
import { FC } from "react";
import JobPreviewCard from "../Cards/JobPreview";

type Props = {
  jobPostings: JobPosting[];
};

const JobContainer: FC<Props> = ({ jobPostings }) => {
  const searchParams = useSearchParams();
  const selectedJobId = searchParams.get("selected");

  const selectedJob = selectedJobId
    ? getSelectedJobData(selectedJobId, jobPostings)
    : undefined;

  return (
    <div
      className={`flex flex-col gap-4 mb-10 ${
        selectedJobId ? "w-[45%]" : "w-full"
      }`}
    >
      {jobPostings.map(({ id, title, company, location, description }) => (
        <JobPreviewCard
          id={id}
          title={title}
          company={company}
          loc={location}
          description={description}
        />
      ))}
    </div>
  );
};

// @ts-ignore
const getSelectedJobData = (jobId: string, jobPostings: JobPosting[]) => {
  for (const posting of jobPostings) {
    if (jobId === posting.id) return posting;
  }
};

export default JobContainer;
