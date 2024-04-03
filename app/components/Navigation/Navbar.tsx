import { JWTPayload } from "@/utils/jwt";
import Image from "next/image";
import { FC } from "react";
import Link from "next/link";
import WorkWiseLogo from "../../public/logo/workwise.svg";

type Props = {
  session?: JWTPayload;
};

const Navbar: FC<Props> = ({ session }) => {
  return (
    <nav className="px-8 py-3 flex justify-between items-center bg-background">
      <Link href="/">
        <Image priority src={WorkWiseLogo} height={60} alt="workwise logo" />
      </Link>

      {/* check for session */}
      {session && (
        <div className="flex gap-6 justify-between items-center text-text">
          <Link href="/saved-jobs">Saved Jobs</Link>
          <Link href="/profile">My Profile</Link>

          <div className="p-2 flex gap-2 justify-center items-center">
            <a href="/api/logout">Logout</a>
            <Image src="" alt="" />
          </div>
        </div>
      )}
    </nav>
  );
};

export default Navbar;
