"use client";
import Link from "next/link";
import { useSearchParams } from "next/navigation";
import { FC } from "react";

type Props = {
  id: string;
  title: string;
  company: string;
  loc: string;
  description: string;
};

const JobPreviewCard: FC<Props> = ({
  id,
  title,
  company,
  loc,
  description,
}) => {
  const searchParams = useSearchParams();
  const selectedJob = searchParams.get("selected");

  return (
    <Link
      href={`/jobs?selected=${id}`}
      className="block bg-white shadow-md rounded-lg p-4"
    >
      <h1
        className={`text-xl font-semibold mb-1 ${
          selectedJob === id ? "text-accent" : "text-black"
        }`}
      >
        {title}
      </h1>
      <div className="text-gray-600">{company}</div>
      <div>{loc}</div>
      <div className="text-gray-800 line-clamp-3">{description}</div>
    </Link>
  );
};

export default JobPreviewCard;
