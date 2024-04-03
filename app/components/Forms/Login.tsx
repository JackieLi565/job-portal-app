"use client";
import { FC, ReactElement } from "react";

type Props = {
  children: ReactElement;
};
const LoginForm: FC<Props> = ({ children }) => {
  return (
    <div className="bg-white p-8 rounded-lg shadow-md w-96">
      <h1 className="text-2xl font-bold mb-2 text-left text-black">Sign in</h1>
      <p className="text-gray-600 text-base mb-6 text-left">
        Jobs search can never be wiser
      </p>
      <Form />
      <div className="text-center text-sm text-gray-500 my-2">or</div>
      {children}
    </div>
  );
};

const Form: FC = () => {
  return (
    <form className="space-y-5">
      <div>
        <input
          type="email"
          className="w-full px-3 py-2 border rounded-md outline-none"
          placeholder="Email"
        />
      </div>

      <div>
        <input
          type="password"
          className="w-full px-3 py-2 border rounded-md outline-none"
          placeholder="Password"
        />
      </div>

      <div>
        <a href="#" className="text-accent">
          Forgot password?
        </a>
      </div>

      <button
        disabled
        type="submit"
        className="w-full py-2 px-4 bg-background text-text rounded-md hover:bg-secondary transition-colors focus:outline-none"
      >
        Sign in
      </button>
    </form>
  );
};

export default LoginForm;
