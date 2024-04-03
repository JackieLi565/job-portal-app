import Link from "next/link";
import { FC } from "react";

const Footer: FC = () => {
  return (
    <footer className="h-16 bg-primary flex items-center justify-center gap-5 text-sm text-background">
      <p>WorkWise © 2024</p>
      <Link href="/user-agreement">User Agreement</Link>
      <Link href="/policy">Privacy Policy</Link>
      <Link href="/community">Community Guidelines</Link>
      <Link href="/cookies">Cookie Policy</Link>
      <Link href="/copyright">Copyright Policy</Link>
      <Link href="/feedback">Feedback</Link>
      <Link href="/support">Support</Link>
    </footer>
  );
};

export default Footer;
