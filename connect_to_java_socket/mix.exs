defmodule ConnectToJavaSocket.MixProject do
  use Mix.Project

  def project do
    [
      app: :connect_to_java_socket,
      version: "0.1.0",
      elixir: "~> 1.13",
      start_permanent: Mix.env() == :prod,
      deps: deps()
    ]
  end

  # Run "mix help compile.app" to learn about applications.
  def application do
    [
      extra_applications: [:logger]
    ]
  end

  # Run "mix help deps" to learn about dependencies.
  defp deps do
    [
      {:socket, "~> 0.3"}
    ]
  end
end
