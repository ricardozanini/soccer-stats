require 'spec_helper'

describe "spring boot example appplication" do
  let(:host) { URI.parse('http://localhost:9090') }

  it "Greetings from Spring Boot" do
    connection = Faraday.new host
    page = connection.get('/').body
    expect(page).to match /Greetings from Spring Boot/
  end

end
