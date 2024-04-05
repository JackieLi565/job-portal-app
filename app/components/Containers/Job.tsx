"use client";
import { JobPosting, getJobPostings } from "@/service/job";
import { useSearchParams } from "next/navigation";
import { FC, useEffect, useState } from "react";
import JobPreviewCard from "../Cards/JobPreview";

const JobContainer: FC = () => {
  const searchParams = useSearchParams();
  const selectedJobId = searchParams.get("selected");
  const location = searchParams.get("loc");
  const keyword = searchParams.get("keyword");

  const [jobPostings, setJobPostings] = useState<JobPosting[]>([]);

  useEffect(() => {
    const handler = async () => {
      const res = await getJobPostings();
      console.log(res);

      setJobPostings(res.data);
    };

    handler();
  }, [location, keyword]);

  const selectedJob =
    selectedJobId && jobPostings
      ? getSelectedJobData(selectedJobId, jobPostings)
      : undefined;

  return (
    <div
      className={`flex flex-col gap-4 mb-10 ${
        selectedJobId ? "w-[45%]" : "w-full"
      }`}
    >
      {jobPostings &&
        jobPostings.map(({ id, title, company, location, description }) => (
          <JobPreviewCard
            key={id}
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

const getSelectedJobData = (jobId: string, jobPostings: JobPosting[]) => {
  for (const posting of jobPostings) {
    if (jobId === posting.id) return posting;
  }
};

export default JobContainer;
