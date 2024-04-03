import LoginForm from "@/components/Forms/Login";
import OAuthConsentLink from "@/components/Links/OAuthConsent";
import Footer from "@/components/Navigation/Footer";
import Navbar from "@/components/Navigation/Navbar";
import { Metadata } from "next";

export const metadata: Metadata = {
  title: "Workwise | Login",
  description:
    "Its a tough market. Login or register to Workwise and start searching wiser!",
};

export default function Home() {
  return (
    <main className="h-screen flex flex-col bg-background">
      <Navbar />
      <section className="flex-1 flex flex-col items-center justify-center">
        <LoginForm>
          <OAuthConsentLink />
        </LoginForm>
        <div className="mt-6 text-center">
          <p className="text-sm text-text">
            New to WorkWise?{" "}
            <a href="/register" className="text-accent">
              Join now
            </a>
          </p>
        </div>
      </section>
      <Footer />
    </main>
  );
}
