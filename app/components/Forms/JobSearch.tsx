"use client";
import { FC } from "react";

const JobSearchForm: FC = () => {
  return (
    <div className="flex flex-col justify-center items-center">
      <div className="flex items-center justify-center pt-10 pb-6">
        <form className="flex rounded">
          <input
            type="text"
            className="px-4 py-2 w-80 outline-none rounded-l"
            placeholder="Job title, keywords, or company"
          />
          <input
            type="text"
            className="px-4 py-2 w-80 outline-none"
            placeholder="City, province, or 'remote'"
          />
          <button className="px-8 rounded-r bg-accent text-white font-bold p-4">
            Find jobs
          </button>
        </form>
      </div>
    </div>
  );
};

export default JobSearchForm;
