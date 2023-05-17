Pod::Spec.new do |s|
    # 1
    s.platform = :ios
    s.ios.deployment_target = '14.1'
    s.name = "KotlinMultiplatformFlavor"
    s.summary = "KMM Library"
    s.requires_arc = true

    # 2
    s.version = "2.0.0"

    # 3
    s.license = { :type => "MIT", :file => "LICENSE" }

    # 4 - Replace with your name and e-mail address
    s.author = { "Thiago Alves" => "thiagoalves@ioasys.com.br" }

    # 5 - Replace this URL with your own GitHub page's URL (from the address bar)
    s.homepage = "https://github.com/thigott/KotlinMultiplataformLibrary"

    # 6 - Replace this URL with your own Git URL from "Quick Setup"
    s.source = { :git => "https://github.com/thigott/KotlinMultiplataformLibrary.git",
                 :tag => "#{s.version}" }

    # 8
    s.source_files = "KotlinMultiplataformLibrary/**/*"
end
