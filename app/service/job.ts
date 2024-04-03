import axios from "axios";

const baseURL = `${process.env.DOMAIN}${process.env.JOB_SERVICE}`;
const instance = axios.create({
  baseURL,
});

export type JobPosting = {
  id: string;
  title: string;
  description: string;
  location: string;
  company: string;
  pay: number;
  date: string;
  interaction: number;
  recruiter: RecruiterMeta;
  url: string;
};

export type RecruiterMeta = {
  id: string;
  name: string;
  lastname: string;
  image: string;
  company: string;
};

export const getJobPostings = async (options?: {
  title: string;
  loc: string;
  page: string;
}) => {
  const queryString = new URLSearchParams(options);

  const res = await instance.get<JobPosting[]>(
    `/jobs?${queryString.toString()}`
  );

  return res;
};

export const incJobViewCount = async (jobId: string) => {
  const res = await instance.patch<JobPosting[]>(
    `/job-interaction?jobId=${jobId}`
  );

  return res;
};
